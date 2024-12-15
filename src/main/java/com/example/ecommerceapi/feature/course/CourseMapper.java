package com.example.ecommerceapi.feature.course;

import com.example.ecommerceapi.domain.Course;
import com.example.ecommerceapi.feature.course.dto.CourseRequest;
import com.example.ecommerceapi.feature.course.dto.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "teacherName", source = "teacher.name")
    CourseResponse toCourseResponse(Course course);

    Course toCourse(CourseRequest courseRequest);

}
