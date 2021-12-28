package com.spstudio.zheng.teacher.outgoing;

import com.spstudio.zheng.domain.model.TeacherDomainObject;
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
    public TeacherDomainObject load(String teacherCode) {
        Optional<Teacher> teacherOptional = teacherRepository.findByTeacherCode(teacherCode);
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            TeacherDomainObject teacherDomainObject = new TeacherDomainObject();
            teacherDomainObject.setCode(teacher.getTeacherCode());
            teacherDomainObject.setEmail(teacher.getEmail());
            teacherDomainObject.setName(teacher.getTeacherName());
            teacherDomainObject.setEnabled(teacher.getEnabled() == 1);
            return teacherDomainObject;
        }
        return null;
    }
}
