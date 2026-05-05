package com.order_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.order_service.dto.OrderLineItemsDto;
import com.order_service.dto.OrderRequest;
import com.order_service.entity.Order;
import com.order_service.entity.OrderLineItems;
import com.order_service.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){

            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());

           List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                        .stream()
                        .map(this::mapToDto)
                        .toList();

            order.setOrderLineItemsList(orderLineItems);
            orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
            OrderLineItems orderLineItems = new OrderLineItems();
            orderLineItems.setPrice(orderLineItems.getPrice());
            orderLineItems.setQuantity(orderLineItems.getQuantity());
            orderLineItems.setSkuCode(orderLineItems.getSkuCode());
            return orderLineItems;
    }
}
