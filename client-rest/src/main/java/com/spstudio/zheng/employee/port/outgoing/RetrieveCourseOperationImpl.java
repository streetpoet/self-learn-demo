package com.spstudio.zheng.employee.port.outgoing;

import com.spstudio.zheng.domain.model.CourseDM;
import com.spstudio.zheng.domain.port.outgoing.RetrieveCourseOperation;
import org.springframework.stereotype.Component;

@Component
public class RetrieveCourseOperationImpl implements RetrieveCourseOperation {
    @Override
    public CourseDM load(String courseCode) {
        return null;
    }
}
