package com.example.ecommerceapi.feature.teacher.dto;

import lombok.Builder;

@Builder
public record TeacherResponse(
        String uuid,
        String name
) {
}
