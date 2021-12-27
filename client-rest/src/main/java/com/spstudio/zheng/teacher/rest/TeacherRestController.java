package com.spstudio.zheng.teacher.rest;

import com.spstudio.zheng.domain.service.TeacherResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TeacherRestController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherResourceService teacherResourceService;

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

    @GetMapping("/test")
    public ResponseEntity<Void> getTeacherInfo() {
        teacherResourceService.add("", "");
        return ResponseEntity.ok().build();
    }
}
