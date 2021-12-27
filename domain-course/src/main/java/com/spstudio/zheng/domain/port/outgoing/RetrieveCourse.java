package com.spstudio.zheng.domain.port.outgoing;

import com.spstudio.zheng.domain.model.CourseDM;

public interface RetrieveCourse {

    CourseDM load(String courseCode);
}
