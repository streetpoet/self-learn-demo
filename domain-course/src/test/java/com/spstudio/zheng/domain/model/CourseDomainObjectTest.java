package com.spstudio.zheng.domain.model;

import org.junit.jupiter.api.Test;

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
        TeacherDomainObject teacherDomainObject = new TeacherDomainObject();
        teacherDomainObject.setCode(code);
        courseDomainObject.addTeacher(teacherDomainObject);
        courseDomainObject.removeTeacher(teacherDomainObject);
        assertEquals(0, courseDomainObject.getAvailableTeachers().size());
        assertFalse(courseDomainObject.isEnabled());
    }
}