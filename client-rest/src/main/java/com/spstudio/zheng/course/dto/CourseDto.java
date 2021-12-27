package com.spstudio.zheng.course.dto;

import com.spstudio.zheng.course.entity.Course;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

public record CourseDto(String courseCode, String courseName) implements Serializable {

    public Course toCourse() {
        Course course = new Course();
        course.setId(UUID.randomUUID().toString());
        course.setEnabled(1);
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        return course;
    }
}
