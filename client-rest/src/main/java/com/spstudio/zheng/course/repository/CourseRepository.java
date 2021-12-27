package com.spstudio.zheng.course.repository;

import com.spstudio.zheng.domain.model.CourseDM;
import com.spstudio.zheng.domain.port.outgoing.PersistCourseOperation;
import com.spstudio.zheng.employee.entity.TeacherEntity;
import com.spstudio.zheng.employee.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseRepository implements PersistCourseOperation {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public void save(CourseDM courseDM) {
        List<TeacherEntity> all = teacherRepository.findAll();
        System.out.println(all);
    }
}
