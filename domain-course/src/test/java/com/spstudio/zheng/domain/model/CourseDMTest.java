package com.spstudio.zheng.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseDMTest {

    @Test
    void addTeacher() {
        CourseDM courseDM = new CourseDM();
        assertTrue(courseDM.getAvailableTeachers().isEmpty());
        assertFalse(courseDM.isEnabled());
        courseDM.addTeacher(new TeacherDM());
        assertEquals(1, courseDM.getAvailableTeachers().size());
        assertTrue(courseDM.isEnabled());
    }

    @Test
    void removeTeacher() {
        String code = "teacher-code";
        CourseDM courseDM = new CourseDM();
        TeacherDM teacherDM = new TeacherDM();
        teacherDM.setCode(code);
        courseDM.addTeacher(teacherDM);
        courseDM.removeTeacher(teacherDM);
        assertEquals(0, courseDM.getAvailableTeachers().size());
        assertFalse(courseDM.isEnabled());
    }
}