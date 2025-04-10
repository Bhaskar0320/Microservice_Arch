package com.bhaskar.order_service.Controller;

import com.bhaskar.order_service.Model.*;
import com.bhaskar.order_service.Repository.*;
import com.bhaskar.order_service.Service.*;
import com.bhaskar.order_service.dto.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";

    }
}
