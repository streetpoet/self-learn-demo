package com.spstudio.zheng.domain.port.outgoing;

import com.spstudio.zheng.domain.model.TeacherDomainObject;

public interface RetrieveTeacher {

    TeacherDomainObject load(String teacherCode);
}
