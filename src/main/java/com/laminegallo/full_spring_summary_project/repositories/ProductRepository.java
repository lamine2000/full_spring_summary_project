package com.laminegallo.full_spring_summary_project.repositories;

import com.laminegallo.full_spring_summary_project.models.Category;
import com.laminegallo.full_spring_summary_project.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByLabel(String label);


    List<Product> findProductsByCategory(Category category);


    List<Product> findProductsByCategoryAndPriceGreaterThanEqualAndPriceLessThanEqual(Category category, double lowerPrice, double higherPrice);

}
