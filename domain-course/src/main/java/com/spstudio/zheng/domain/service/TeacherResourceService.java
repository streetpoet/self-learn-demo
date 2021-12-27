package com.spstudio.zheng.domain.service;

import com.spstudio.zheng.domain.model.CourseDM;
import com.spstudio.zheng.domain.model.TeacherDM;
import com.spstudio.zheng.domain.port.incoming.IAddTeacherToCourse;
import com.spstudio.zheng.domain.port.incoming.IRemoveTeacherFromCourse;
import com.spstudio.zheng.domain.port.outgoing.PersistCourseOperation;
import com.spstudio.zheng.domain.port.outgoing.RetrieveCourseOperation;
import com.spstudio.zheng.domain.port.outgoing.RetrieveTeacherOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class TeacherResourceService implements IAddTeacherToCourse, IRemoveTeacherFromCourse {

    private RetrieveCourseOperation retrieveCourseOperation;
    private RetrieveTeacherOperation retrieveTeacherOperation;
    private PersistCourseOperation persistCourseOperation;

    @Override
    public void add(String teacherCode, String courseCode) {
        TeacherDM teacherDM = retrieveTeacherOperation.load(teacherCode);
        CourseDM courseDM = retrieveCourseOperation.load(courseCode);
        if (teacherDM == null || courseDM == null) {
            log.warn("-> can not found teacherDM or courseDM, teacherDM={} courseDM={}", teacherDM, courseDM);
        } else {
            courseDM.addTeacher(teacherDM);
            persistCourseOperation.save(courseDM);
        }
    }

    @Override
    public void removeTeacherFromCourse(String teacherCode, String courseCode) {
        TeacherDM teacherDM = retrieveTeacherOperation.load(teacherCode);
        CourseDM courseDM = retrieveCourseOperation.load(courseCode);
        if (teacherDM == null || courseDM == null) {
            log.warn("-> can not found teacherDM or courseDM, teacherDM={} courseDM={}", teacherDM, courseDM);
        } else {
            courseDM.removeTeacher(teacherDM);
            persistCourseOperation.save(courseDM);
        }
    }
}
