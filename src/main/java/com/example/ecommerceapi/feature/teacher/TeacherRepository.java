package com.example.ecommerceapi.feature.teacher;

import com.example.ecommerceapi.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    Optional<Teacher> findByUuid (String uuid);

    Optional<Teacher> findByName (String name);
}
