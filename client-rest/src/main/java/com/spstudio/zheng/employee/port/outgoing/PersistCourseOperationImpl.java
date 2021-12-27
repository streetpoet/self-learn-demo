package com.spstudio.zheng.employee.port.outgoing;

import com.spstudio.zheng.domain.model.CourseDM;
import com.spstudio.zheng.domain.port.outgoing.PersistCourseOperation;
import org.springframework.stereotype.Component;

@Component
public class PersistCourseOperationImpl implements PersistCourseOperation {
    @Override
    public void save(CourseDM courseDM) {

    }
}
