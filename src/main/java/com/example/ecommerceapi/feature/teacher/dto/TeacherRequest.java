package com.example.ecommerceapi.feature.teacher.dto;

import lombok.Builder;

@Builder
public record TeacherRequest(
        String name
) {
}
