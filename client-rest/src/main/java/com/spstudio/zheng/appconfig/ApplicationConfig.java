package com.spstudio.zheng.appconfig;

import com.spstudio.zheng.domain.port.outgoing.PersistCourseTeacherRel;
import com.spstudio.zheng.domain.port.outgoing.RetrieveCourse;
import com.spstudio.zheng.domain.port.outgoing.RetrieveTeacher;
import com.spstudio.zheng.domain.service.CourseTeacherRelationshipService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    CourseTeacherRelationshipService teacherResourceService(RetrieveCourse retrieveCourse,
                                                            RetrieveTeacher retrieveTeacher,
                                                            PersistCourseTeacherRel persistCourseTeacherRel) {
        return new CourseTeacherRelationshipService(retrieveCourse, retrieveTeacher, persistCourseTeacherRel);
    }

}
