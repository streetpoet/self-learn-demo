package com.spstudio.zheng.course.port.outgoing;

import com.spstudio.zheng.course.entity.Course;
import com.spstudio.zheng.course.repository.CourseRepository;
import com.spstudio.zheng.domain.model.CourseDM;
import com.spstudio.zheng.domain.port.outgoing.RetrieveCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RetrieveCourseImpl implements RetrieveCourse {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public CourseDM load(String courseCode) {
        Optional<Course> courseOptional = courseRepository.findByCourseCode(courseCode);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            CourseDM courseDM = new CourseDM();
            courseDM.setCode(course.getCourseCode());
            courseDM.setName(course.getCourseName());
            courseDM.setEnabled(course.getEnabled() == 1);
        }
        return null;
    }
}
