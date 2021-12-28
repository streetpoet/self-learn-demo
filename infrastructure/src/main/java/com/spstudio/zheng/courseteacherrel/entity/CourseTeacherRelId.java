package com.spstudio.zheng.courseteacherrel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class CourseTeacherRelId implements Serializable {

    @Serial
    private static final long serialVersionUID = -2519027334758837011L;

    @Column(name = "course_id", nullable = false, length = 36)
    private String courseId;

    @Column(name = "teacher_id", nullable = false, length = 36)
    private String teacherId;
}