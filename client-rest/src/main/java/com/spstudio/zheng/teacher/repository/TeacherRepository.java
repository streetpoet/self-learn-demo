package com.spstudio.zheng.teacher.repository;

import com.spstudio.zheng.teacher.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TeacherRepository extends JpaRepository<TeacherEntity, UUID> {

    public List<TeacherEntity> findByEmail(String email);
}
