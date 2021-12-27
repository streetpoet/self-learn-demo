package com.spstudio.zheng.courseteacherrel.entity;

import com.spstudio.zheng.common.entity.AuditMetaData;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "course_teacher_rel")
@EntityListeners(AuditingEntityListener.class)
public class CourseTeacherRel {
    @EmbeddedId
    private CourseTeacherRelId id;

    @Embedded
    private final AuditMetaData auditMetaData = new AuditMetaData();

    public CourseTeacherRelId getId() {
        return id;
    }

    public void setId(CourseTeacherRelId id) {
        this.id = id;
    }
}