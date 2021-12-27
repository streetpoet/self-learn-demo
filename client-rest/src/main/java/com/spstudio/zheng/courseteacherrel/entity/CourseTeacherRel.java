package com.spstudio.zheng.courseteacherrel.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course_teacher_rel")
public class CourseTeacherRel {
    @EmbeddedId
    private CourseTeacherRelId id;

    public CourseTeacherRelId getId() {
        return id;
    }

    public void setId(CourseTeacherRelId id) {
        this.id = id;
    }
}