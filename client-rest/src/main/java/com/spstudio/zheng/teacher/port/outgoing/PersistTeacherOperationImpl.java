package com.spstudio.zheng.teacher.port.outgoing;

import com.spstudio.zheng.domain.model.TeacherDM;
import com.spstudio.zheng.domain.port.outgoing.PersistTeacherOperation;
import org.springframework.stereotype.Component;

@Component
public class PersistTeacherOperationImpl implements PersistTeacherOperation {
    @Override
    public void save(TeacherDM teacherDM) {

    }
}
