package com.example.ecommerceapi.feature.order.dto;

import lombok.Builder;

@Builder
public record OrderRequest(
        int quantity,
        Long productId,
        Long userId
) {
}
