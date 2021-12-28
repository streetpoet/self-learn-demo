package com.spstudio.zheng.domain.port.outgoing;

import com.spstudio.zheng.domain.model.TeacherDomainObject;

import java.util.Optional;

public interface IRetrieveTeacher {

    Optional<TeacherDomainObject> loadByTeacherCode(String teacherCode);
}
