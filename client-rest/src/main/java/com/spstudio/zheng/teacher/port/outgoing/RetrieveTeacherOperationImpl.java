package com.spstudio.zheng.teacher.port.outgoing;

import com.spstudio.zheng.domain.model.TeacherDM;
import com.spstudio.zheng.domain.port.outgoing.RetrieveTeacherOperation;
import org.springframework.stereotype.Component;

@Component
public class RetrieveTeacherOperationImpl implements RetrieveTeacherOperation {
    @Override
    public TeacherDM load(String teacherCode) {
        return null;
    }
}
