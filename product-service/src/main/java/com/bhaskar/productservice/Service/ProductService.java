package com.bhaskar.productservice.Service;


import com.bhaskar.productservice.Repository.*;
import com.bhaskar.productservice.dto.*;
import com.bhaskar.productservice.model.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    final private ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();


        productRepository.save(product);

        log.info("Product {} created: " , product.getId());
    }

    public List<ProductResponse> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> new ProductResponse(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()))
                .collect(Collectors.toList());
    }
}
