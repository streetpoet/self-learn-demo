package com.spstudio.zheng.domain.port.outgoing;

import com.spstudio.zheng.domain.model.TeacherDM;

public interface RetrieveTeacher {

    TeacherDM load(String teacherCode);
}
