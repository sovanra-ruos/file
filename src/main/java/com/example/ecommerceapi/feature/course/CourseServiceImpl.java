package com.example.ecommerceapi.feature.course;

import com.example.ecommerceapi.domain.Course;
import com.example.ecommerceapi.domain.Teacher;
import com.example.ecommerceapi.feature.course.dto.CourseRequest;
import com.example.ecommerceapi.feature.course.dto.CourseResponse;
import com.example.ecommerceapi.feature.teacher.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final TeacherRepository teacherRepository;

    @Override
    public void createCourse(CourseRequest courseRequest) {

        Course course = courseMapper.toCourse(courseRequest);

        Teacher teacher = teacherRepository.findByName(courseRequest.teacherName()).orElseThrow(
                () -> new NoSuchElementException("Teacher not found")
        );

        course.setUuid(UUID.randomUUID().toString());
        course.setName(courseRequest.name());
        course.setDescription(courseRequest.description());
        course.setTeacher(teacher);

        courseRepository.save(course);

    }

    @Override
    public List<CourseResponse> getAllCourses() {

        List<Course> courses = courseRepository.findAll();

        return courses.stream()
                .map(courseMapper::toCourseResponse)
                .toList();

    }


}
