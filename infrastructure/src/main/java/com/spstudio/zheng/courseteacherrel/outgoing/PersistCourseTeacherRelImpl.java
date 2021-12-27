package com.spstudio.zheng.courseteacherrel.outgoing;

import com.spstudio.zheng.course.repository.CourseRepository;
import com.spstudio.zheng.courseteacherrel.entity.CourseTeacherRel;
import com.spstudio.zheng.courseteacherrel.entity.CourseTeacherRelId;
import com.spstudio.zheng.courseteacherrel.repository.CourseTeacherRelRepository;
import com.spstudio.zheng.domain.model.CourseDM;
import com.spstudio.zheng.domain.model.TeacherDM;
import com.spstudio.zheng.domain.port.outgoing.PersistCourseTeacherRel;
import com.spstudio.zheng.teacher.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class PersistCourseTeacherRelImpl implements PersistCourseTeacherRel {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseTeacherRelRepository courseTeacherRelRepository;

    @Override
    public void save(CourseDM courseDM) {
        List<TeacherDM> availableTeachers = courseDM.getAvailableTeachers();
        for (TeacherDM teacherDM : availableTeachers) {
            String courseId = courseRepository.findByCourseCode(courseDM.getCode()).orElseThrow().getId();
            String teacherId = teacherRepository.findByTeacherCode(teacherDM.getCode()).orElseThrow().getId();
            CourseTeacherRelId courseTeacherRelId = new CourseTeacherRelId();
            courseTeacherRelId.setCourseId(courseId);
            courseTeacherRelId.setTeacherId(teacherId);
            Optional<CourseTeacherRel> optionalCourseTeacherRel = courseTeacherRelRepository.findById(courseTeacherRelId);
            if (optionalCourseTeacherRel.isEmpty()) {
                CourseTeacherRel courseTeacherRel = new CourseTeacherRel();
                courseTeacherRel.setId(courseTeacherRelId);
                courseTeacherRelRepository.save(courseTeacherRel);
                log.info("-> entity saved. entity={}", courseTeacherRel);
            } else {
                log.info("-> entity already exists. entity={}", optionalCourseTeacherRel.get());
            }
        }

    }
}
