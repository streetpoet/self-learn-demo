package com.spstudio.zheng.courseteacherrel.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseTeacherRelId implements Serializable {
    private static final long serialVersionUID = -2519027334758837011L;
    @Column(name = "course_id", nullable = false, length = 36)
    private String courseId;
    @Column(name = "teacher_id", nullable = false, length = 36)
    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, courseId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CourseTeacherRelId entity = (CourseTeacherRelId) o;
        return Objects.equals(this.teacherId, entity.teacherId) &&
                Objects.equals(this.courseId, entity.courseId);
    }
}