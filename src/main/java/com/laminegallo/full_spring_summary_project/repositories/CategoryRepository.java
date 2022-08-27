package com.laminegallo.full_spring_summary_project.repositories;

import com.laminegallo.full_spring_summary_project.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
