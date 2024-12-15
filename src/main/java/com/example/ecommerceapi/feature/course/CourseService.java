package com.example.ecommerceapi.feature.course;

import com.example.ecommerceapi.feature.course.dto.CourseRequest;
import com.example.ecommerceapi.feature.course.dto.CourseResponse;

import java.util.List;

public interface CourseService {

    void createCourse(CourseRequest courseRequest);

    List<CourseResponse> getAllCourses();

}
