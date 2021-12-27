package com.spstudio.zheng.courseteacherrel.controller;

import com.spstudio.zheng.domain.service.TeacherResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseTeacherRelRestController {

    @Autowired
    TeacherResourceService teacherResourceService;

    @PostMapping("/teacher-course-rel")
    public ResponseEntity<Void> addTeacherToCourse(@RequestBody CreateTeacherToCourseRequest request) {
        teacherResourceService.addTeacherToCourse(request.teacherCode, request.courseCode);
        return ResponseEntity.ok().build();
    }

    public record CreateTeacherToCourseRequest(String teacherCode, String courseCode) {
    }
}
