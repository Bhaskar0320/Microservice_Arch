package com.bhaskar.order_service.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.*;
import java.util.*;

@Entity
@Table(name = "t_order_line_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
