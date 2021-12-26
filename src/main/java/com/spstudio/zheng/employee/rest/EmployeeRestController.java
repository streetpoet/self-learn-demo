package com.spstudio.zheng.employee.rest;

import com.spstudio.zheng.employee.entity.TeacherEntity;
import com.spstudio.zheng.employee.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class EmployeeRestController {

    @Autowired
    TeacherRepository teacherRepository;

    @PostMapping("/teacher")
    public ResponseEntity<Void> postTeacherEndpoint() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(UUID.randomUUID().toString());
        teacherEntity.setTeacherName("teacher name");
        teacherEntity.setEmail("other@gmail.com");
        teacherEntity.setMobilePhone("7371002000");
        teacherEntity.setEnabled(1);
        teacherRepository.save(teacherEntity);
        return ResponseEntity.ok().build();
    }
}
