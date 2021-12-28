package com.spstudio.zheng.domain.port.outgoing;

import com.spstudio.zheng.domain.model.CourseDomainObject;

import java.util.Optional;

public interface IRetrieveCourse {

    Optional<CourseDomainObject> loadByCourseCode(String courseCode);
}
