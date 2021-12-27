package com.spstudio.zheng.domain.port.outgoing;

import com.spstudio.zheng.domain.model.TeacherDM;

public interface RetrieveTeacherOperation {

    TeacherDM load(String teacherCode);
}
