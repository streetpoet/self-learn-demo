package com.spstudio.zheng.appconfig;

import com.spstudio.zheng.domain.port.outgoing.PersistCourseOperation;
import com.spstudio.zheng.domain.port.outgoing.RetrieveCourseOperation;
import com.spstudio.zheng.domain.port.outgoing.RetrieveTeacherOperation;
import com.spstudio.zheng.domain.service.TeacherResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    TeacherResourceService teacherResourceService(RetrieveCourseOperation retrieveCourseOperation,
                                                  RetrieveTeacherOperation retrieveTeacherOperation,
                                                  PersistCourseOperation persistCourseOperation) {
        return new TeacherResourceService(retrieveCourseOperation, retrieveTeacherOperation, persistCourseOperation);
    }

}
