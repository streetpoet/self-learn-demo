package com.spstudio.zheng.teacher.dto;

import com.spstudio.zheng.teacher.entity.TeacherEntity;

import java.io.Serializable;
import java.util.UUID;

public record TeacherDto(String teacherCode, String teacherName,
                         String mobilePhone, String email) implements Serializable {

    public TeacherEntity toTeacher() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(UUID.randomUUID().toString());
        teacherEntity.setEnabled(1);
        teacherEntity.setTeacherCode(teacherCode);
        teacherEntity.setTeacherName(teacherName);
        teacherEntity.setMobilePhone(mobilePhone);
        teacherEntity.setEmail(email);
        return teacherEntity;
    }
}
