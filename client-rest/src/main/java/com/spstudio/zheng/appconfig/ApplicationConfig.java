package com.spstudio.zheng.appconfig;

import com.spstudio.zheng.domain.port.outgoing.PersistCourseTeacherRel;
import com.spstudio.zheng.domain.port.outgoing.IRetrieveCourse;
import com.spstudio.zheng.domain.port.outgoing.IRetrieveTeacher;
import com.spstudio.zheng.domain.service.CourseTeacherRelationshipService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    CourseTeacherRelationshipService teacherResourceService(IRetrieveCourse IRetrieveCourse,
                                                            IRetrieveTeacher IRetrieveTeacher,
                                                            PersistCourseTeacherRel persistCourseTeacherRel) {
        return new CourseTeacherRelationshipService(IRetrieveCourse, IRetrieveTeacher, persistCourseTeacherRel);
    }

}
