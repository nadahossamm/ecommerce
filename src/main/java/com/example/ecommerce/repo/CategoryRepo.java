package com.example.ecommerce.repo;

import com.example.ecommerce.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long > {
    Category findByCategoryName(String categoryName);
}
