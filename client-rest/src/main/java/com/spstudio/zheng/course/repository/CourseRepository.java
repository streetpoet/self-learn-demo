package com.spstudio.zheng.course.repository;

import com.spstudio.zheng.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}