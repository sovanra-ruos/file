package com.example.ecommerceapi.feature.order;

import com.example.ecommerceapi.domain.Order;
import com.example.ecommerceapi.domain.Product;
import com.example.ecommerceapi.domain.User;
import com.example.ecommerceapi.feature.order.dto.OrderRequest;
import com.example.ecommerceapi.feature.order.dto.OrderResponse;
import com.example.ecommerceapi.feature.order.dto.OrderUpdateRequest;
import com.example.ecommerceapi.feature.product.ProductRepository;
import com.example.ecommerceapi.feature.user.UserRepository;
import com.example.ecommerceapi.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;


    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = orderMapper.toOrder(orderRequest);

        Product product = productRepository.findById(orderRequest.productId()).orElseThrow(
                () -> new NoSuchElementException("Product not found")
        );
        User user = userRepository.findById(orderRequest.userId()).orElseThrow(
                () -> new NoSuchElementException("User not found")
        );
        order.setTotalPrice(product.getPrice() * orderRequest.quantity());
        order.setProduct(product);
        order.setUser(user);
        order.setStatus("PENDING");
        orderRepository.save(order);

        return orderMapper.toOrderResponse(order);
    }

    @Override
    public OrderResponse getOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Order not found")
        );
        return orderMapper.toOrderResponse(order);
    }


    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Order not found")
        );
        orderRepository.delete(order);

    }

    @Override
    public OrderResponse updateOrderStatus(Long id, OrderUpdateRequest orderUpdateRequest) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Order not found")
        );
        order.setStatus(orderUpdateRequest.status());
        orderRepository.save(order);
        return orderMapper.toOrderResponse(order);
    }

    @Override
    public List<OrderResponse> getOrdersByUserId(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream().map(orderMapper::toOrderResponse).toList();
    }
}
