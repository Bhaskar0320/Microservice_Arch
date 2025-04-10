package com.bhaskar.productservice.Repository;

import com.bhaskar.productservice.model.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.data.repository.*;

public interface ProductRepository extends MongoRepository<Product, String> {

}