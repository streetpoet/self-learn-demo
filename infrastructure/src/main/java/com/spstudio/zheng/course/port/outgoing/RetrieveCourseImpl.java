package com.spstudio.zheng.course.port.outgoing;

import com.spstudio.zheng.course.entity.Course;
import com.spstudio.zheng.course.repository.CourseRepository;
import com.spstudio.zheng.courseteacherrel.repository.CourseTeacherRelRepository;
import com.spstudio.zheng.domain.model.CourseDomainObject;
import com.spstudio.zheng.domain.model.TeacherDomainObject;
import com.spstudio.zheng.domain.port.outgoing.RetrieveCourse;
import com.spstudio.zheng.teacher.entity.Teacher;
import com.spstudio.zheng.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RetrieveCourseImpl implements RetrieveCourse {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseTeacherRelRepository courseTeacherRelRepository;

    @Override
    public CourseDomainObject load(String courseCode) {
        Optional<Course> courseOptional = courseRepository.findByCourseCode(courseCode);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            CourseDomainObject courseDomainObject = new CourseDomainObject();
            courseDomainObject.setCode(course.getCourseCode());
            courseDomainObject.setName(course.getCourseName());
            courseDomainObject.setEnabled(course.getEnabled() == 1);

            List<String> teacherIds = courseTeacherRelRepository.findByIdCourseId(course.getId())
                    .stream().map(t -> t.getId().getTeacherId()).collect(Collectors.toList());
            List<Teacher> teachers = teacherRepository.findAllById(teacherIds);
            List<TeacherDomainObject> teacherDomainObjects = teachers.stream().map(t -> {
                TeacherDomainObject teacherDomainObject = new TeacherDomainObject();
                teacherDomainObject.setId(t.getId());
                teacherDomainObject.setEnabled(t.getEnabled() == 1);
                teacherDomainObject.setCode(t.getTeacherCode());
                teacherDomainObject.setName(t.getTeacherName());
                teacherDomainObject.setCode(t.getEmail());
                return teacherDomainObject;
            }).collect(Collectors.toList());
            courseDomainObject.setAvailableTeacherCodes(teacherDomainObjects);
            return courseDomainObject;
        }
        return null;
    }
}
