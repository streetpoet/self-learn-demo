package com.spstudio.zheng.domain.port.incoming;

public interface IRemoveTeacherFromCourse {

    void removeTeacherFromCourse(String teacherCode, String courseCode);
}
