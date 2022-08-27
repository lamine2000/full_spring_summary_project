package com.laminegallo.full_spring_summary_project.repositories;

import com.laminegallo.full_spring_summary_project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findById(long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByBirthDate(Date birthDAte);

    Optional<User> findByBirthDateGreaterThan(Date lowerBound);

    Optional<List<User>> findByFirstName(String firstName);

    Optional<List<User>> findByLastName(String lastName);

    Optional<List<User>> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<List<User>> findByFirstNameOrLastName(String firstName, String lastName);
}
