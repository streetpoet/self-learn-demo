package com.spstudio.zheng.teacher.entity;

import com.spstudio.zheng.common.entity.AuditMetaData;
import com.spstudio.zheng.domain.model.TeacherDomainObject;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teacher")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Teacher {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "teacher_code", nullable = false, length = 10)
    private String teacherCode;

    @Column(name = "teacher_name", nullable = false, length = 20)
    private String teacherName;

    @Column(name = "mobile_phone", nullable = false, length = 20)
    private String mobilePhone;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "enabled", nullable = false)
    private Integer enabled;

    @Embedded
    private AuditMetaData auditMetaData = new AuditMetaData();

    public TeacherDomainObject toDomainObject() {
        TeacherDomainObject teacherDomainObject = new TeacherDomainObject();
        teacherDomainObject.setId(this.id);
        teacherDomainObject.setEnabled(this.enabled == 1);
        teacherDomainObject.setCode(this.teacherCode);
        teacherDomainObject.setName(this.teacherName);
        teacherDomainObject.setEmail(this.email);
        return teacherDomainObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Teacher teacher = (Teacher) o;
        return id != null && Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}