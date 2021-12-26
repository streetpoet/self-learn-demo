package com.spstudio.zheng.employee.entity;

import com.spstudio.common.entity.AuditMetaData;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@EntityListeners(AuditingEntityListener.class)
@Data
public class TeacherEntity {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

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

}