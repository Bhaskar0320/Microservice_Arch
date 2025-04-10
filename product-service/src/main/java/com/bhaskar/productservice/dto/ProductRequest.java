package com.bhaskar.productservice.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private double price;
    private String description;
    private String name;
}
