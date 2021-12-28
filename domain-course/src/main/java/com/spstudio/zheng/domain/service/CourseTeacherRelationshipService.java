package com.spstudio.zheng.domain.service;

import com.spstudio.zheng.domain.model.CourseDomainObject;
import com.spstudio.zheng.domain.model.TeacherDomainObject;
import com.spstudio.zheng.domain.port.incoming.IAddTeacherToCourse;
import com.spstudio.zheng.domain.port.incoming.IRemoveTeacherFromCourse;
import com.spstudio.zheng.domain.port.outgoing.PersistCourseTeacherRel;
import com.spstudio.zheng.domain.port.outgoing.RetrieveCourse;
import com.spstudio.zheng.domain.port.outgoing.RetrieveTeacher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class CourseTeacherRelationshipService implements IAddTeacherToCourse, IRemoveTeacherFromCourse {

    private RetrieveCourse retrieveCourse;
    private RetrieveTeacher retrieveTeacher;
    private PersistCourseTeacherRel persistCourseTeacherRel;

    @Override
    public void addTeacherToCourse(String teacherCode, String courseCode) {
        TeacherDomainObject teacherDomainObject = retrieveTeacher.load(teacherCode);
        CourseDomainObject courseDomainObject = retrieveCourse.load(courseCode);
        if (teacherDomainObject == null || courseDomainObject == null) {
            log.warn("-> can not found teacherDM or courseDM, teacherDM={} courseDM={}", teacherDomainObject, courseDomainObject);
        } else {
            courseDomainObject.addTeacherByCode(teacherDomainObject.getCode());
            persistCourseTeacherRel.save(courseDomainObject);
        }
    }

    @Override
    public void removeTeacherFromCourse(String teacherCode, String courseCode) {
        TeacherDomainObject teacherDomainObject = retrieveTeacher.load(teacherCode);
        CourseDomainObject courseDomainObject = retrieveCourse.load(courseCode);
        if (teacherDomainObject == null || courseDomainObject == null) {
            log.warn("-> can not found teacherDM or courseDM, teacherDM={} courseDM={}", teacherDomainObject, courseDomainObject);
        } else {
            courseDomainObject.removeTeacherCode(teacherDomainObject.getId());
            persistCourseTeacherRel.save(courseDomainObject);
        }
    }
}
