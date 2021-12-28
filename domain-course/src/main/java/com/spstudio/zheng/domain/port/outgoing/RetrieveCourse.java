package com.spstudio.zheng.domain.port.outgoing;

import com.spstudio.zheng.domain.model.CourseDomainObject;

public interface RetrieveCourse {

    CourseDomainObject load(String courseCode);
}
