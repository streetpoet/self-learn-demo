package com.spstudio.zheng.teacher.outgoing;

import com.spstudio.zheng.domain.model.TeacherDM;
import com.spstudio.zheng.domain.port.outgoing.RetrieveTeacher;
import com.spstudio.zheng.teacher.entity.Teacher;
import com.spstudio.zheng.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RetrieveTeacherImpl implements RetrieveTeacher {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public TeacherDM load(String teacherCode) {
        Optional<Teacher> teacherOptional = teacherRepository.findByTeacherCode(teacherCode);
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            TeacherDM teacherDM = new TeacherDM();
            teacherDM.setCode(teacher.getTeacherCode());
            teacherDM.setEmail(teacher.getEmail());
            teacherDM.setName(teacher.getTeacherName());
            teacherDM.setEnabled(teacher.getEnabled() == 1);
            return teacherDM;
        }
        return null;
    }
}
