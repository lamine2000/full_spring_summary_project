package com.laminegallo.full_spring_summary_project.services.impl;

import com.laminegallo.full_spring_summary_project.models.Role;
import com.laminegallo.full_spring_summary_project.models.User;
import com.laminegallo.full_spring_summary_project.repositories.UserRepository;
import com.laminegallo.full_spring_summary_project.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.xml.bind.ValidationException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public User register(User userRequest) throws ValidationException {
        // verifier si l'utilisateur existe
        if(userRepository.findByUsername(userRequest.getUsername()).isPresent())
            throw new ValidationException("L'utilisateur existe déjà");

        //si l'utilisatur n'a pas de rôle, lui donner le role User
        if(userRequest.getAuthorities() == null || userRequest.getAuthorities().isEmpty())
            userRequest.setRoles(Set.of(new Role(Role.USER)));

        User user = userRequest;

        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User login(User userRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));

        return (User) authentication.getPrincipal();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByBirthDate(Date birthDAte) {
        return userRepository.findByBirthDate(birthDAte);
    }

    @Override
    public Optional<User> findByBirthDateGreaterThan(Date lowerBound) {
        return userRepository.findByBirthDateGreaterThan(lowerBound);
    }

    @Override
    public Optional<List<User>> findByFistName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public Optional<List<User>> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public Optional<List<User>> findByFistNameAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Optional<List<User>> findByFistNameOrLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameOrLastName(firstName, lastName);
    }
}
