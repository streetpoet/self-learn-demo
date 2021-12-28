package com.spstudio.zheng.courseteacherrel.outgoing;

import com.spstudio.zheng.courseteacherrel.entity.CourseTeacherRel;
import com.spstudio.zheng.courseteacherrel.entity.CourseTeacherRelId;
import com.spstudio.zheng.courseteacherrel.repository.CourseTeacherRelRepository;
import com.spstudio.zheng.domain.model.CourseDomainObject;
import com.spstudio.zheng.domain.model.TeacherDomainObject;
import com.spstudio.zheng.domain.port.outgoing.PersistCourseTeacherRel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class PersistCourseTeacherRelImpl implements PersistCourseTeacherRel {

    @Autowired
    CourseTeacherRelRepository courseTeacherRelRepository;

    @Override
    public void save(CourseDomainObject courseDomainObject) {
        List<TeacherDomainObject> availableTeachers = courseDomainObject.getAvailableTeacherCodes();
        for (TeacherDomainObject teacherDomainObject : availableTeachers) {
            CourseTeacherRelId courseTeacherRelId = getCourseTeacherRelId(courseDomainObject, teacherDomainObject);
            Optional<CourseTeacherRel> optionalCourseTeacherRel = courseTeacherRelRepository.findById(courseTeacherRelId);
            if (optionalCourseTeacherRel.isEmpty()) {
                CourseTeacherRel courseTeacherRel = getCourseTeacherRel(courseTeacherRelId);
                courseTeacherRelRepository.save(courseTeacherRel);
                log.info("-> entity saved. entity={}", courseTeacherRel);
            } else {
                log.info("-> entity already exists. entity={}", optionalCourseTeacherRel.get());
            }
        }

    }

    private CourseTeacherRel getCourseTeacherRel(CourseTeacherRelId courseTeacherRelId) {
        CourseTeacherRel courseTeacherRel = new CourseTeacherRel();
        courseTeacherRel.setId(courseTeacherRelId);
        return courseTeacherRel;
    }

    private CourseTeacherRelId getCourseTeacherRelId(CourseDomainObject courseDomainObject, TeacherDomainObject teacherDomainObject) {
        String courseId = courseDomainObject.getId();
        String teacherId = teacherDomainObject.getId();
        CourseTeacherRelId courseTeacherRelId = new CourseTeacherRelId();
        courseTeacherRelId.setCourseId(courseId);
        courseTeacherRelId.setTeacherId(teacherId);
        return courseTeacherRelId;
    }
}
