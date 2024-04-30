package com.example.ecommerceapi.feature.order;

import com.example.ecommerceapi.feature.order.dto.OrderRequest;
import com.example.ecommerceapi.feature.order.dto.OrderResponse;
import com.example.ecommerceapi.feature.order.dto.OrderUpdateRequest;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
    OrderResponse getOrder(Long id);
    void deleteOrder(Long id);
    OrderResponse updateOrderStatus(Long id, OrderUpdateRequest orderUpdateRequest);
    List<OrderResponse> getOrdersByUserId(Long userId);
}
