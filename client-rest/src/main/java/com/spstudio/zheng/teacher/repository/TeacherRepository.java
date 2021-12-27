package com.spstudio.zheng.teacher.repository;

import com.spstudio.zheng.teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
}