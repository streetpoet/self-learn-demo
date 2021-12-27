package com.spstudio.zheng.teacher.entity;

import com.spstudio.zheng.common.entity.AuditMetaData;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@EntityListeners(AuditingEntityListener.class)
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

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}