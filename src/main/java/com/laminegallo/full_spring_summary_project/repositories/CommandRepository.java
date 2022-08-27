package com.laminegallo.full_spring_summary_project.repositories;

import com.laminegallo.full_spring_summary_project.models.Command;
import com.laminegallo.full_spring_summary_project.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command, Long> {

    Command findCommandByDelivery(Delivery delivery);

}
