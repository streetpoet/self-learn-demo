package com.spstudio.zheng.domain.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CourseDomainObjectTest {

    @Test
    void addTeacher() {
        CourseDomainObject courseDomainObject = new CourseDomainObject();
        assertTrue(courseDomainObject.getAvailableTeacherCodes().isEmpty());
        assertFalse(courseDomainObject.isEnabled());
        courseDomainObject.addTeacherByCode("teacherCode");
        assertEquals(1, courseDomainObject.getAvailableTeacherCodes().size());
        assertTrue(courseDomainObject.isEnabled());
    }

    @Test
    void removeTeacher() {
        String code = "teacher-code";
        CourseDomainObject courseDomainObject = new CourseDomainObject();
        Set<String> teacherCodes = new HashSet<>();
        teacherCodes.add("teacherCode");
        courseDomainObject.setAvailableTeacherCodes(teacherCodes);
        courseDomainObject.removeTeacherCode("teacherCode");
        assertEquals(0, courseDomainObject.getAvailableTeacherCodes().size());
        assertFalse(courseDomainObject.isEnabled());
    }
}