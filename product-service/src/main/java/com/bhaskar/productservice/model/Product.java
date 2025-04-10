package com.bhaskar.productservice.model;


import lombok.*;
import org.springframework.aot.generate.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;


@Document(value = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    private String id;
    private String name;
    private double price;
    private String description;
}
