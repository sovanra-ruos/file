package com.example.ecommerceapi.feature.order;

import com.example.ecommerceapi.feature.order.dto.OrderRequest;
import com.example.ecommerceapi.feature.order.dto.OrderResponse;
import com.example.ecommerceapi.feature.order.dto.OrderUpdateRequest;
import com.example.ecommerceapi.utils.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping
    @Operation(summary = "Create order")
    public BaseResponse<OrderResponse> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        return BaseResponse.<OrderResponse>ok()
                .setPayload(orderService.createOrder(orderRequest));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get all orders by user id")
    public BaseResponse<List<OrderResponse>> getOrderByUserId(@PathVariable Long userId) {
        return BaseResponse.<List<OrderResponse>>ok()
                .setPayload(orderService.getOrdersByUserId(userId));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by id")
    public BaseResponse<OrderResponse> getOrder(@PathVariable Long id) {
        return BaseResponse.<OrderResponse>ok().setPayload(orderService.getOrder(id));
    }


    @PatchMapping("/{id}/status")
    @Operation(summary = "Update order status")
    public BaseResponse<OrderResponse> updateOrderStatus(@PathVariable Long id, OrderUpdateRequest orderUpdateRequest) {
        return BaseResponse.<OrderResponse>ok().setPayload(orderService.updateOrderStatus(id, orderUpdateRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete order by id")
    public BaseResponse<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return BaseResponse.<Void>ok();
    }



}
