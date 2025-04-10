package com.bhaskar.productservice.dto;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String id;
    private String description;
    private String name;
    private double price;
}
