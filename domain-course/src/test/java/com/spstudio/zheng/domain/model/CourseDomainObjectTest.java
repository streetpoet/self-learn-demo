package com.spstudio.zheng.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseDomainObjectTest {

    @Test
    void addTeacher() {
        CourseDomainObject courseDomainObject = new CourseDomainObject();
        assertTrue(courseDomainObject.getAvailableTeachers().isEmpty());
        assertFalse(courseDomainObject.isEnabled());
        courseDomainObject.addTeacher(new TeacherDM());
        assertEquals(1, courseDomainObject.getAvailableTeachers().size());
        assertTrue(courseDomainObject.isEnabled());
    }

    @Test
    void removeTeacher() {
        String code = "teacher-code";
        CourseDomainObject courseDomainObject = new CourseDomainObject();
        TeacherDM teacherDM = new TeacherDM();
        teacherDM.setCode(code);
        courseDomainObject.addTeacher(teacherDM);
        courseDomainObject.removeTeacher(teacherDM);
        assertEquals(0, courseDomainObject.getAvailableTeachers().size());
        assertFalse(courseDomainObject.isEnabled());
    }
}