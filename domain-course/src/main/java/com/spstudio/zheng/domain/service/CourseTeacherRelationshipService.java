package com.spstudio.zheng.domain.service;

import com.spstudio.zheng.domain.model.CourseDomainObject;
import com.spstudio.zheng.domain.model.TeacherDomainObject;
import com.spstudio.zheng.domain.port.incoming.IAddTeacherToCourse;
import com.spstudio.zheng.domain.port.incoming.IRemoveTeacherFromCourse;
import com.spstudio.zheng.domain.port.outgoing.IRetrieveCourse;
import com.spstudio.zheng.domain.port.outgoing.IRetrieveTeacher;
import com.spstudio.zheng.domain.port.outgoing.PersistCourseTeacherRelationship;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@AllArgsConstructor
@Slf4j
public class CourseTeacherRelationshipService implements IAddTeacherToCourse, IRemoveTeacherFromCourse {

    private IRetrieveCourse retrieveCourse;
    private IRetrieveTeacher retrieveTeacher;
    private PersistCourseTeacherRelationship persistCourseTeacherRelationship;

    @Override
    public void addTeacherToCourse(String teacherCode, String courseCode) {
        Optional<TeacherDomainObject> teacherDomainObject = retrieveTeacher.loadByTeacherCode(teacherCode);
        Optional<CourseDomainObject> courseDomainObject = retrieveCourse.loadByCourseCode(courseCode);
        if (teacherDomainObject.isEmpty() || courseDomainObject.isEmpty()) {
            log.warn("-> can not found teacherDM or courseDM, teacherDM={} courseDM={}", teacherDomainObject, courseDomainObject);
        } else {
            courseDomainObject.get().addTeacher(teacherDomainObject.get());
            persistCourseTeacherRelationship.save(courseDomainObject.get());
        }
    }

    @Override
    public void removeTeacherFromCourse(String teacherCode, String courseCode) {
        Optional<TeacherDomainObject> teacherDomainObject = retrieveTeacher.loadByTeacherCode(teacherCode);
        Optional<CourseDomainObject> courseDomainObject = retrieveCourse.loadByCourseCode(courseCode);
        if (teacherDomainObject.isEmpty() || courseDomainObject.isEmpty()) {
            log.warn("-> can not found teacherDM or courseDM, teacherDM={} courseDM={}", teacherDomainObject, courseDomainObject);
        } else {
            courseDomainObject.get().removeTeacher(teacherDomainObject.get());
            persistCourseTeacherRelationship.save(courseDomainObject.get());
        }
    }
}
