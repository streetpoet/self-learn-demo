package com.spstudio.zheng.course.entity;

import com.spstudio.zheng.common.entity.AuditMetaData;
import com.spstudio.zheng.domain.model.CourseDomainObject;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "course")
@EntityListeners(AuditingEntityListener.class)
public class Course {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "course_code", nullable = false, length = 10)
    private String courseCode;

    @Column(name = "course_name", nullable = false, length = 45)
    private String courseName;

    @Column(name = "enabled", nullable = false)
    private Integer enabled;

    @Embedded
    private final AuditMetaData auditMetaData = new AuditMetaData();

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
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

    public CourseDomainObject toDomainObject() {
        CourseDomainObject courseDomainObject = new CourseDomainObject();
        courseDomainObject.setId(this.id);
        courseDomainObject.setCode(this.courseCode);
        courseDomainObject.setName(this.courseName);
        courseDomainObject.setEnabled(this.enabled == 1);
        return courseDomainObject;
    }
}