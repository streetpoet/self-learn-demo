package com.spstudio.zheng.teacher.dto;

import com.spstudio.zheng.teacher.entity.Teacher;

import java.io.Serializable;
import java.util.UUID;

public record TeacherDto(String teacherCode, String teacherName,
                         String mobilePhone, String email) implements Serializable {

    public Teacher toTeacher() {
        Teacher teacher = new Teacher();
        teacher.setId(UUID.randomUUID().toString());
        teacher.setEnabled(1);
        teacher.setTeacherCode(teacherCode);
        teacher.setTeacherName(teacherName);
        teacher.setMobilePhone(mobilePhone);
        teacher.setEmail(email);
        return teacher;
    }
}
