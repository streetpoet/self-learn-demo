package com.spstudio.zheng.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Data
@Slf4j
public class CourseDomainObject {

    @Setter(AccessLevel.NONE)
    private String id;
    private String code;
    private String name;
    private boolean enabled;

    private Set<String> availableTeacherCodes = new HashSet<>();

    public void addTeacherByCode(String teacherCode) {
        if (availableTeacherCodes.contains(teacherCode)) {
            log.info("-> event=course already contains specified teacher, courseCode={} teacherCode={}", code, teacherCode);
        } else {
            availableTeacherCodes.add(teacherCode);
        }
        if (availableTeacherCodes.size() == 1) {
            enabled = true;
        }
    }

    public void removeTeacherCode(String teacherCode) {
        boolean removed = availableTeacherCodes.remove(teacherCode);
        if (removed && availableTeacherCodes.size() == 0) {
            enabled = false;
        }
    }

}
