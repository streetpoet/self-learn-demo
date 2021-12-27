package com.spstudio.zheng.course.entity;

import com.spstudio.zheng.common.entity.AuditMetaData;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "course_code", nullable = false, length = 10)
    private String courseCode;

    @Column(name = "course_name", nullable = false, length = 45)
    private String courseName;

    @Column(name = "enabled", nullable = false, length = 45)
    private String enabled;

    @Embedded
    private AuditMetaData auditMetaData = new AuditMetaData();

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}