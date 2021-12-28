package com.spstudio.zheng.courseteacherrel.entity;

import com.spstudio.zheng.common.entity.AuditMetaData;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_teacher_rel")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CourseTeacherRel {

    @EmbeddedId
    private CourseTeacherRelId id;

    @Embedded
    private final AuditMetaData auditMetaData = new AuditMetaData();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CourseTeacherRel that = (CourseTeacherRel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}