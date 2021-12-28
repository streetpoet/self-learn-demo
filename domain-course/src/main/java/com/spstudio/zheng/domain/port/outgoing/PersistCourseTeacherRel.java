package com.spstudio.zheng.domain.port.outgoing;

import com.spstudio.zheng.domain.model.CourseDomainObject;

public interface PersistCourseTeacherRel {

    void save(CourseDomainObject courseDomainObject);
}
