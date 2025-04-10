package com.bhaskar.productservice.Controller;


import com.bhaskar.productservice.Service.*;
import com.bhaskar.productservice.dto.*;
import com.bhaskar.productservice.model.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
    productService.createProduct(productRequest);
}


@GetMapping
@ResponseStatus(HttpStatus.OK)
public List<ProductResponse> getAllProducts() {

        return productService.getAllProduct();
}

}
