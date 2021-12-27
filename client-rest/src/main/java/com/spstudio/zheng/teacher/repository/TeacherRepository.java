package com.spstudio.zheng.teacher.repository;

import com.spstudio.zheng.teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

    Optional<Teacher> findByTeacherCode(String teacherCode);

    List<Teacher> findByEmail(String email);
}