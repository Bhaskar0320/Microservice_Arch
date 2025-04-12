package com.bhaskar.order_service.Controller;

import com.bhaskar.order_service.Model.*;
import com.bhaskar.order_service.Repository.*;
import com.bhaskar.order_service.Service.*;
import com.bhaskar.order_service.dto.*;
import io.github.resilience4j.circuitbreaker.annotation.*;
import io.github.resilience4j.retry.annotation.*;
import io.github.resilience4j.timelimiter.annotation.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {

        //before implementing time limiter
        //        orderService.placeOrder(orderRequest);
        //        return "Order Placed Successfully";

        return orderService.placeOrder(orderRequest);

    }

    public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException) {
        return CompletableFuture.supplyAsync(() -> "Oops... Something went wrong");
    }
}
