package com.spstudio.zheng.teacher.port.incoming;

import com.spstudio.zheng.domain.port.incoming.IRemoveTeacherFromCourse;
import org.springframework.stereotype.Component;

@Component
public class RemoveTeacherFromCourseImpl implements IRemoveTeacherFromCourse {

    @Override
    public void removeTeacherFromCourse(String teacherCode, String courseCode) {

    }
}
