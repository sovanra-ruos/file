package com.example.ecommerceapi.feature.teacher;

import com.example.ecommerceapi.domain.Teacher;
import com.example.ecommerceapi.feature.teacher.dto.TeacherRequest;
import com.example.ecommerceapi.feature.teacher.dto.TeacherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public void createTeacher(TeacherRequest teacherRequest) {

        Teacher teacher = teacherMapper.toTeacher(teacherRequest);

        teacher.setUuid(UUID.randomUUID().toString());

        teacher.setName(teacherRequest.name());

        teacherRepository.save(teacher);

    }

    @Override
    public void updateTeacher(String uuid, TeacherRequest teacherRequest) {

        Teacher teacher = teacherRepository.findByUuid(uuid).orElseThrow(
                () -> new NoSuchElementException("Teacher not found")
        );

        teacher.setName(teacherRequest.name());

        teacherRepository.save(teacher);


    }

    @Override
    public void deleteTeacher(String uuid) {

        Teacher teacher = teacherRepository.findByUuid(uuid).orElseThrow(
                () -> new NoSuchElementException("Teacher not found")
        );

        teacherRepository.delete(teacher);

    }

    @Override
    public TeacherResponse getTeacher(String uuid) {
        return null;
    }
}
