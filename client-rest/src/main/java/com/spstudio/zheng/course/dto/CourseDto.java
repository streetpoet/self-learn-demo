package com.spstudio.zheng.course.dto;

import com.spstudio.zheng.course.entity.CourseEntity;

import java.io.Serializable;
import java.util.UUID;

public record CourseDto(String courseCode, String courseName) implements Serializable {

    public CourseEntity toCourse() {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(UUID.randomUUID().toString());
        courseEntity.setEnabled(1);
        courseEntity.setCourseCode(courseCode);
        courseEntity.setCourseName(courseName);
        return courseEntity;
    }
}
