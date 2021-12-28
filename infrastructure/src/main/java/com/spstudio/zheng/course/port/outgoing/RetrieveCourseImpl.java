package com.spstudio.zheng.course.port.outgoing;

import com.spstudio.zheng.course.entity.CourseEntity;
import com.spstudio.zheng.course.repository.CourseRepository;
import com.spstudio.zheng.courseteacherrel.repository.CourseTeacherRelRepository;
import com.spstudio.zheng.domain.model.CourseDomainObject;
import com.spstudio.zheng.domain.model.TeacherDomainObject;
import com.spstudio.zheng.domain.port.outgoing.IRetrieveCourse;
import com.spstudio.zheng.teacher.entity.Teacher;
import com.spstudio.zheng.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RetrieveCourseImpl implements IRetrieveCourse {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseTeacherRelRepository courseTeacherRelRepository;

    @Override
    public Optional<CourseDomainObject> loadByCourseCode(String courseCode) {
        Optional<CourseEntity> courseOptional = courseRepository.findByCourseCode(courseCode);
        if (courseOptional.isPresent()) {
            CourseEntity courseEntity = courseOptional.get();
            CourseDomainObject courseDomainObject = courseEntity.toDomainObject();
            List<String> teacherIds = courseTeacherRelRepository.findByIdCourseId(courseEntity.getId())
                    .stream().map(t -> t.getId().getTeacherId()).collect(Collectors.toList());
            List<Teacher> teachers = teacherRepository.findAllById(teacherIds);
            Set<TeacherDomainObject> teacherDomainObjects = teachers.stream().map(Teacher::toDomainObject).collect(Collectors.toSet());
            courseDomainObject.setAvailableTeachers(teacherDomainObjects);
            return Optional.of(courseDomainObject);
        }
        return Optional.empty();
    }
}
