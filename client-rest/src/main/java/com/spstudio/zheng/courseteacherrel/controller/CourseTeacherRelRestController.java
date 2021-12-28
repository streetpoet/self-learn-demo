package com.spstudio.zheng.courseteacherrel.controller;

import com.spstudio.zheng.courseteacherrel.request.CreateTeacherCourseRelationshipRequest;
import com.spstudio.zheng.domain.port.incoming.IAddTeacherToCourse;
import com.spstudio.zheng.domain.port.incoming.IRemoveTeacherFromCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseTeacherRelRestController {

    @Autowired
    IAddTeacherToCourse addTeacherToCourse;

    @Autowired
    IRemoveTeacherFromCourse removeTeacherFromCourse;

    @PostMapping("/teacher-course-rel")
    public ResponseEntity<Void> addTeacherToCourse(@RequestBody CreateTeacherCourseRelationshipRequest request) {
        addTeacherToCourse.addTeacherToCourse(request.teacherCode(), request.courseCode());
        return ResponseEntity.ok().build();
    }
}
