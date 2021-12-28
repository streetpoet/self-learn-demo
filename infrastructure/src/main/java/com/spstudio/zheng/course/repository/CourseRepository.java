package com.spstudio.zheng.course.repository;

import com.spstudio.zheng.course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {

    Optional<CourseEntity> findByCourseCode(String courseCode);
}