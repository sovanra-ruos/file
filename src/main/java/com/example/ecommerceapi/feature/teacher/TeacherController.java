package com.example.ecommerceapi.feature.teacher;

import com.example.ecommerceapi.feature.teacher.dto.TeacherRequest;
import com.example.ecommerceapi.feature.teacher.dto.TeacherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/{uuid}")
    public ResponseEntity<TeacherResponse> getTeacherByUuid(@PathVariable String uuid) {
        return ResponseEntity.ok(teacherService.getTeacher(uuid));
    }


    @PostMapping
    public ResponseEntity<String> createTeacher(@RequestBody TeacherRequest teacherRequest) {
        teacherService.createTeacher(teacherRequest);
        return ResponseEntity.ok("Teacher created");
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity<String > updateTeacher(@PathVariable String uuid, @RequestBody TeacherRequest teacherRequest) {
        teacherService.updateTeacher(uuid, teacherRequest);
        return ResponseEntity.ok("Teacher updated");
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteTeacher(@PathVariable String uuid) {
        teacherService.deleteTeacher(uuid);
        return ResponseEntity.ok("Teacher deleted");
    }

}
