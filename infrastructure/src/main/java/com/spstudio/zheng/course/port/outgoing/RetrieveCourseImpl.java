package com.spstudio.zheng.course.port.outgoing;

import com.spstudio.zheng.course.entity.Course;
import com.spstudio.zheng.course.repository.CourseRepository;
import com.spstudio.zheng.domain.model.CourseDomainObject;
import com.spstudio.zheng.domain.port.outgoing.RetrieveCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RetrieveCourseImpl implements RetrieveCourse {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public CourseDomainObject load(String courseCode) {
        Optional<Course> courseOptional = courseRepository.findByCourseCode(courseCode);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            CourseDomainObject courseDomainObject = new CourseDomainObject();
            courseDomainObject.setCode(course.getCourseCode());
            courseDomainObject.setName(course.getCourseName());
            courseDomainObject.setEnabled(course.getEnabled() == 1);
            return courseDomainObject;
        }
        return null;
    }
}
