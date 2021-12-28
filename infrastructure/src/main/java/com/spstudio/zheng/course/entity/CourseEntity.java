package com.spstudio.zheng.course.entity;

import com.spstudio.zheng.common.entity.AuditMetaData;
import com.spstudio.zheng.domain.model.CourseDomainObject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@RequiredArgsConstructor
public class CourseEntity {
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

    public CourseDomainObject toDomainObject() {
        CourseDomainObject courseDomainObject = new CourseDomainObject();
        courseDomainObject.setId(this.id);
        courseDomainObject.setCode(this.courseCode);
        courseDomainObject.setName(this.courseName);
        courseDomainObject.setEnabled(this.enabled == 1);
        return courseDomainObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CourseEntity that = (CourseEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}