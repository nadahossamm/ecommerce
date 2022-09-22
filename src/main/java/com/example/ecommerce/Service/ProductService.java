package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.ProductDto;
import com.example.ecommerce.Entity.Category;
import com.example.ecommerce.Entity.Product;
import com.example.ecommerce.repo.CategoryRepo;
import com.example.ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;


    public Product  addProduct(ProductDto productDto, Category category)
    {
        Product product = new Product();
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        product.setProductName(productDto.getProductName());
        return product;
    }
    public ProductDto getProductDto(Product product)
    {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setProductName(product.getProductName());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setId(product.getId());
        return productDto;
    }
    public List<ProductDto> getAllProduct() {
        List <Product> products= productRepo.findAll();
        List<ProductDto> productDtos=new ArrayList<>();
        for (Product product:products) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }


    public void updateProduct(ProductDto productDto, Long productId) throws Exception {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        // throw an exception if product does not exists
        if (!optionalProduct.isPresent()) {
            throw new Exception("product not present");
        }
        Product product = optionalProduct.get();
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
    }
}
