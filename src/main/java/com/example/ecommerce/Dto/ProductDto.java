package com.example.ecommerce.Dto;

import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private String description;
    private String imageUrl;
    private Long price;
    private Long categoryId;
}
