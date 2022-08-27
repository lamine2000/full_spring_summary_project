package com.laminegallo.full_spring_summary_project.services;

import com.laminegallo.full_spring_summary_project.models.User;

import javax.swing.text.html.Option;
import javax.xml.bind.ValidationException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User register(User userRequest) throws ValidationException;

    User login(User userRequest);

    Optional<User> findById(long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByBirthDate(Date birthDAte);

    Optional<User> findByBirthDateGreaterThan(Date lowerBound);

    Optional<List<User>> findByFistName(String firstName);

    Optional<List<User>> findByLastName(String lastName);

    Optional<List<User>> findByFistNameAndLastName(String firstName, String lastName);

    Optional<List<User>> findByFistNameOrLastName(String firstName, String lastName);
}
