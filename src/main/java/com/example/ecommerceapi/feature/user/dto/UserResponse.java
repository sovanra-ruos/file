package com.example.ecommerceapi.feature.user.dto;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String userName, String email,String password,String profileImage, String role,boolean is_Deleted) {
}
