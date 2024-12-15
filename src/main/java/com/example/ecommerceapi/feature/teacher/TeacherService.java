package com.example.ecommerceapi.feature.teacher;

import com.example.ecommerceapi.feature.teacher.dto.TeacherRequest;
import com.example.ecommerceapi.feature.teacher.dto.TeacherResponse;

public interface TeacherService {

    void createTeacher(TeacherRequest teacherRequest);

    void updateTeacher(String uuid, TeacherRequest teacherRequest);

    void deleteTeacher(String uuid);

    TeacherResponse getTeacher(String uuid);

}
