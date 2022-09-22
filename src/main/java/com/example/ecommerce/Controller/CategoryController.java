package com.example.ecommerce.Controller;

import com.example.ecommerce.Entity.Category;
import com.example.ecommerce.Service.CategoryService;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<Category>> getAllCategories()
    {
        List <Category> categories=categoryService.listCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        if (Objects.nonNull(categoryService.readCategory(category.getCategoryName()))) {
            return new ResponseEntity<>( HttpStatus.CONFLICT);
        }
        categoryService.createCategory(category);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @PutMapping("/updateCategory/{categoryID}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable Long categoryID,  @RequestBody Category category) {
        // Check to see if the category exists.
        if (Objects.nonNull(categoryService.readCategory(categoryID))) {
            // If the category exists then update it.
            categoryService.updateCategory(categoryID, category);
            return new ResponseEntity<ApiResponse>( HttpStatus.OK);
        }

        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }


}
