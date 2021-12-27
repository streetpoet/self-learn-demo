package com.spstudio.zheng.employee.port.incoming;

import com.spstudio.zheng.domain.port.incoming.IAddTeacherToCourse;
import org.springframework.stereotype.Component;

@Component
public class AddTeacherToCourseImpl implements IAddTeacherToCourse {

    @Override
    public void add(String teacherCode, String courseCode) {

    }
}
