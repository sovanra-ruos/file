package com.example.ecommerceapi.feature.course;

import com.example.ecommerceapi.feature.course.dto.CourseRequest;
import com.example.ecommerceapi.feature.course.dto.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCourse(@RequestBody CourseRequest courseRequest) {
        courseService.createCourse(courseRequest);
        return ResponseEntity.ok("Course created");
    }

}
