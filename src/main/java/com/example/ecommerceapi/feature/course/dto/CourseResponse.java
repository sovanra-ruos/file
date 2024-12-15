package com.example.ecommerceapi.feature.course.dto;

import lombok.Builder;

@Builder
public record CourseResponse(
        String uuid,
        String name,
        String description,
        String teacherName
) {
}
