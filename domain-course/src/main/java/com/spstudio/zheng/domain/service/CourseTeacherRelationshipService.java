package com.spstudio.zheng.domain.service;

import com.spstudio.zheng.domain.model.CourseDM;
import com.spstudio.zheng.domain.model.TeacherDM;
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
        TeacherDM teacherDM = retrieveTeacher.load(teacherCode);
        CourseDM courseDM = retrieveCourse.load(courseCode);
        if (teacherDM == null || courseDM == null) {
            log.warn("-> can not found teacherDM or courseDM, teacherDM={} courseDM={}", teacherDM, courseDM);
        } else {
            courseDM.addTeacher(teacherDM);
            persistCourseTeacherRel.save(courseDM);
        }
    }

    @Override
    public void removeTeacherFromCourse(String teacherCode, String courseCode) {
        TeacherDM teacherDM = retrieveTeacher.load(teacherCode);
        CourseDM courseDM = retrieveCourse.load(courseCode);
        if (teacherDM == null || courseDM == null) {
            log.warn("-> can not found teacherDM or courseDM, teacherDM={} courseDM={}", teacherDM, courseDM);
        } else {
            courseDM.removeTeacher(teacherDM);
            persistCourseTeacherRel.save(courseDM);
        }
    }
}
