package com.spstudio.zheng.courseteacherrel.outgoing;

import com.spstudio.zheng.courseteacherrel.entity.CourseTeacherRelationshipEntity;
import com.spstudio.zheng.courseteacherrel.entity.CourseTeacherRelId;
import com.spstudio.zheng.courseteacherrel.repository.CourseTeacherRelRepository;
import com.spstudio.zheng.domain.model.CourseDomainObject;
import com.spstudio.zheng.domain.model.TeacherDomainObject;
import com.spstudio.zheng.domain.port.outgoing.PersistCourseTeacherRelationship;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Component
public class PersistCourseTeacherRelationshipImpl implements PersistCourseTeacherRelationship {

    @Autowired
    CourseTeacherRelRepository courseTeacherRelRepository;

    @Override
    public void save(CourseDomainObject courseDomainObject) {
        Set<TeacherDomainObject> availableTeachers = courseDomainObject.getAvailableTeachers();
        for (TeacherDomainObject teacher : availableTeachers) {
            CourseTeacherRelId courseTeacherRelId = getCourseTeacherRelId(courseDomainObject, teacher);
            Optional<CourseTeacherRelationshipEntity> optionalCourseTeacherRel = courseTeacherRelRepository.findById(courseTeacherRelId);
            if (optionalCourseTeacherRel.isEmpty()) {
                CourseTeacherRelationshipEntity courseTeacherRelationshipEntity = getCourseTeacherRel(courseTeacherRelId);
                courseTeacherRelRepository.save(courseTeacherRelationshipEntity);
                log.info("-> entity saved. entity={}", courseTeacherRelationshipEntity);
            } else {
                log.info("-> entity already exists. entity={}", optionalCourseTeacherRel.get());
            }
        }

    }

    private CourseTeacherRelationshipEntity getCourseTeacherRel(CourseTeacherRelId courseTeacherRelId) {
        CourseTeacherRelationshipEntity courseTeacherRelationshipEntity = new CourseTeacherRelationshipEntity();
        courseTeacherRelationshipEntity.setId(courseTeacherRelId);
        return courseTeacherRelationshipEntity;
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
