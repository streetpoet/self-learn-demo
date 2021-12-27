package com.spstudio.zheng.courseteacherrel.repository;

import com.spstudio.zheng.courseteacherrel.entity.CourseTeacherRel;
import com.spstudio.zheng.courseteacherrel.entity.CourseTeacherRelId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseTeacherRelRepository extends JpaRepository<CourseTeacherRel, CourseTeacherRelId> {
}