package com.spstudio.zheng.domain.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CourseDomainObjectTest {

    @Test
    void addTeacher() {
        CourseDomainObject courseDomainObject = new CourseDomainObject();
        assertTrue(courseDomainObject.getAvailableTeachers().isEmpty());
        assertFalse(courseDomainObject.isEnabled());
        courseDomainObject.addTeacher(new TeacherDomainObject());
        assertEquals(1, courseDomainObject.getAvailableTeachers().size());
        assertTrue(courseDomainObject.isEnabled());
    }

    @Test
    void removeTeacher() {
        String code = "teacher-code";
        CourseDomainObject courseDomainObject = new CourseDomainObject();
        Set<TeacherDomainObject> teacherCodes = new HashSet<>();
        TeacherDomainObject teacherDomainObject = new TeacherDomainObject();
        teacherDomainObject.setCode(code);
        teacherCodes.add(teacherDomainObject);
        courseDomainObject.setAvailableTeachers(teacherCodes);
        courseDomainObject.removeTeacher(teacherDomainObject);
        assertEquals(0, courseDomainObject.getAvailableTeachers().size());
        assertFalse(courseDomainObject.isEnabled());
    }
}