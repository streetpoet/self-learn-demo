package com.spstudio.zheng.courseteacherrel.repository;

import com.spstudio.zheng.courseteacherrel.entity.CourseTeacherRelationshipEntity;
import com.spstudio.zheng.courseteacherrel.entity.CourseTeacherRelId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseTeacherRelRepository extends JpaRepository<CourseTeacherRelationshipEntity, CourseTeacherRelId> {

    List<CourseTeacherRelationshipEntity> findByIdCourseId(String courseId);
}