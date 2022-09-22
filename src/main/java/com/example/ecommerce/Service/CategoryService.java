package com.example.ecommerce.Service;

import com.example.ecommerce.Entity.Category;
import com.example.ecommerce.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService  {
    @Autowired
    CategoryRepo categoryRepo;


    public List<Category> listCategories() {
        return categoryRepo.findAll();
    }

    public void createCategory(Category category) {
        categoryRepo.save(category);
    }

    public Category readCategory(String categoryName) {
        return categoryRepo.findByCategoryName(categoryName);
    }

    public Optional<Category> readCategory(Long categoryId) {
        return categoryRepo.findById(categoryId);
    }

    public void updateCategory(Long categoryID, Category newCategory) {
        Category category = categoryRepo.findById(categoryID).get();
        category.setCategoryName(newCategory.getCategoryName());
        category.setImageUrl(newCategory.getImageUrl());
        categoryRepo.save(category);
    }
}
