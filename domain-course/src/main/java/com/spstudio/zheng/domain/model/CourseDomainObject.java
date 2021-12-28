package com.spstudio.zheng.domain.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Data
@Slf4j
public class CourseDomainObject {

    private String id;
    private String code;
    private String name;
    private boolean enabled;

    private Set<TeacherDomainObject> availableTeachers = new HashSet<>();

    public void addTeacher(TeacherDomainObject teacher) {
        if (availableTeachers.stream().anyMatch(t -> t.getCode().equals(teacher.getCode()))) {
            log.info("-> course already contains specified teacher, courseCode={} teacher={}", code, teacher);
        } else {
            availableTeachers.add(teacher);
        }
        if (availableTeachers.size() == 1) {
            enabled = true;
        }
    }

    public void removeTeacher(TeacherDomainObject teacher) {
        boolean removed = availableTeachers.removeIf(t -> t.getCode().equals(teacher.getCode()));
        if (removed && availableTeachers.size() == 0) {
            enabled = false;
        }
    }

}
