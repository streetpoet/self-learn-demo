package com.spstudio.zheng.teacher.repository;

import com.spstudio.zheng.teacher.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherEntity, String> {

    Optional<TeacherEntity> findByTeacherCode(String teacherCode);

    List<TeacherEntity> findByEmail(String email);
}