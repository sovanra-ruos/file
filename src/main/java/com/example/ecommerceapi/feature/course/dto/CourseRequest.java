package com.example.ecommerceapi.feature.course.dto;

public record CourseRequest(
        String name,
        String description,
        String teacherName
) {
}
