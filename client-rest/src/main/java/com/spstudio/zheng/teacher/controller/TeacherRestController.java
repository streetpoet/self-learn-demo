package com.spstudio.zheng.teacher.controller;

import com.spstudio.zheng.teacher.dto.TeacherDto;
import com.spstudio.zheng.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherRestController {

    @Autowired
    TeacherRepository teacherRepository;

    @PostMapping("/teacher")
    public ResponseEntity<Void> createTeacher(@RequestBody TeacherDto teacherDto) {
        teacherRepository.save(teacherDto.toTeacher());
        return ResponseEntity.ok().build();
    }
}
