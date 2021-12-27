package com.spstudio.zheng.course.controller;

import com.spstudio.zheng.course.dto.CourseDto;
import com.spstudio.zheng.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseRestController {

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/course")
    public ResponseEntity<Void> createCourse(@RequestBody CourseDto courseDto) {
        courseRepository.save(courseDto.toCourse());
        return ResponseEntity.ok().build();
    }
}
