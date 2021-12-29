package com.spstudio.zheng.domain.port.incoming;

public interface IAddTeacherToCourse {

    void addTeacherToCourse(String teacherCode, String courseCode) throws AddTeacherToCourseRuntimeException;

    class AddTeacherToCourseRuntimeException extends RuntimeException {
    }
}
