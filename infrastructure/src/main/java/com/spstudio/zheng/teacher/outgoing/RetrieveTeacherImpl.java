package com.spstudio.zheng.teacher.outgoing;

import com.spstudio.zheng.domain.model.TeacherDomainObject;
import com.spstudio.zheng.domain.port.outgoing.IRetrieveTeacher;
import com.spstudio.zheng.teacher.entity.Teacher;
import com.spstudio.zheng.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RetrieveTeacherImpl implements IRetrieveTeacher {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Optional<TeacherDomainObject> loadByTeacherCode(String teacherCode) {
        Optional<Teacher> teacherOptional = teacherRepository.findByTeacherCode(teacherCode);
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            return Optional.of(teacher.toDomainObject());
        }
        return Optional.empty();
    }
}
