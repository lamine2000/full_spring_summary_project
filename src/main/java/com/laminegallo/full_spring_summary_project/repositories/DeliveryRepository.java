package com.laminegallo.full_spring_summary_project.repositories;

import com.laminegallo.full_spring_summary_project.models.Command;
import com.laminegallo.full_spring_summary_project.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    Delivery findDeliveryByCommand(Command command);

}
