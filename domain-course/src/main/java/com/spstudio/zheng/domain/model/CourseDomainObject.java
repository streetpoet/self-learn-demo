package com.spstudio.zheng.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDomainObject {

    private String code;
    private String name;
    private boolean enabled;

    @Setter(AccessLevel.NONE)
    private List<TeacherDomainObject> availableTeachers = new ArrayList<>();

    public void addTeacher(TeacherDomainObject teacherDomainObject) {
        availableTeachers.add(teacherDomainObject);
        // only the first teacher will turn on course status
        if (availableTeachers.size() == 1) {
            enabled = true;
        }
    }

    public void removeTeacher(TeacherDomainObject teacherDomainObject) {
        boolean removed = availableTeachers.removeIf(t -> t.getCode().equals(teacherDomainObject.getCode()));
        if (removed && availableTeachers.size() == 0) {
            enabled = false;
        }
    }

}
