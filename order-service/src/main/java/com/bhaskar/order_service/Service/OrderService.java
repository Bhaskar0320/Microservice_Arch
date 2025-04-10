package com.bhaskar.order_service.Service;

import com.bhaskar.order_service.Model.*;
import com.bhaskar.order_service.Repository.*;
import com.bhaskar.order_service.dto.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.reactive.function.client.*;
//import org.springframework.web.reactive.function.client.*;

import java.util.*;
import java.util.stream.*;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

       List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDtp)
                .collect(Collectors.toList());

       order.setOrderLineItemsList(orderLineItems);

      List<String> skuCodes =  order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList();

       //call inventory service and place order if in stock
        //

        InventoryResponse[] inventoryResponsesArray = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                        .retrieve()
                                .bodyToMono(InventoryResponse[].class)
                                        .block();

        boolean allProductsInStock = Arrays.stream(inventoryResponsesArray).allMatch(InventoryResponse::isInStock);

        if(allProductsInStock) {
       orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
    }

    private OrderLineItems mapToDtp(OrderLineItemsDto orderLineItemsDto) {
    OrderLineItems orderLineItems = new OrderLineItems();
    orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
    orderLineItems.setPrice(orderLineItemsDto.getPrice());
    orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
    return orderLineItems;

    }
}
