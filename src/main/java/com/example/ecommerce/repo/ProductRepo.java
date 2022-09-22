package com.example.ecommerce.repo;

import com.example.ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo  extends JpaRepository<Product,Long> {
}
