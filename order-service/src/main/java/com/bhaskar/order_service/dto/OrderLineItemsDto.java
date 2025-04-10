package com.bhaskar.order_service.dto;

import jakarta.persistence.*;
import lombok.*;

import java.math.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {

    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
