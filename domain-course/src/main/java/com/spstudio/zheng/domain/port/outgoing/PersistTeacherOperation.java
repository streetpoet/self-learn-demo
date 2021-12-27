package com.spstudio.zheng.domain.port.outgoing;

import com.spstudio.zheng.domain.model.TeacherDM;

public interface PersistTeacherOperation {

    void save(TeacherDM teacherDM);
}
