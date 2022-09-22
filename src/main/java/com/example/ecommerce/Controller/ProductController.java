package com.example.ecommerce.Controller;

import com.example.ecommerce.Dto.ProductDto;
import com.example.ecommerce.Entity.Category;
import com.example.ecommerce.Service.ProductService;
import com.example.ecommerce.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryRepo categoryRepo;

    @PostMapping("/addProduct")
    public ResponseEntity<?>addProdct(ProductDto productDto)
    {
        Optional<Category> category =  categoryRepo.findById(productDto.getCategoryId());
        if(category.isPresent())
        {
            Category category1=category.get();
            productService.addProduct(productDto, category1);
               return new ResponseEntity<>( HttpStatus.CREATED);
        }
        return new ResponseEntity<>( HttpStatus.CONFLICT);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDto>>getAllProduct(){
        List <ProductDto> productDtos = productService.getAllProduct();
        return new ResponseEntity<>(productDtos,HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?>updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto) throws Exception {
        Optional<Category> category = categoryRepo.findById(productDto.getCategoryId());
        if(!category.isPresent())
            return new ResponseEntity<>( HttpStatus.CONFLICT);
        productService.updateProduct(productDto, id);
        return new ResponseEntity<>( HttpStatus.OK);

    }

}
