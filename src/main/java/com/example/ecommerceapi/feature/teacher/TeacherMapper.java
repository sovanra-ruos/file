package com.example.ecommerceapi.feature.teacher;

import com.example.ecommerceapi.domain.Teacher;
import com.example.ecommerceapi.feature.teacher.dto.TeacherRequest;
import com.example.ecommerceapi.feature.teacher.dto.TeacherResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherResponse toTeacherResponse(Teacher teacher);

    Teacher toTeacher(TeacherRequest teacherRequest);

}
