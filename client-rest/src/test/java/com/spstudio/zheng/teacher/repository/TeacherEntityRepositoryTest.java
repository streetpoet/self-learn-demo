package com.spstudio.zheng.teacher.repository;

import com.spstudio.zheng.teacher.entity.TeacherEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TeacherEntityRepositoryTest {

    private static final String EMAIL = "teacher@gmail.com";

    @Autowired
    TeacherRepository teacherRepository;

    @BeforeEach
    void before() {
        List<TeacherEntity> teacherEntityEntities = teacherRepository.findByEmail(EMAIL);
        teacherRepository.deleteAll(teacherEntityEntities);
    }

    @Test
    void findAll() {
        List<TeacherEntity> teacherEntityEntities = teacherRepository.findByEmail(EMAIL);
        assertEquals(0, teacherEntityEntities.size());
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(UUID.randomUUID().toString());
        teacherEntity.setTeacherCode("TEST001");
        teacherEntity.setTeacherName("teacher name");
        teacherEntity.setEmail(EMAIL);
        teacherEntity.setMobilePhone("7371002000");
        teacherEntity.setEnabled(1);
        TeacherEntity savedTeacherEntity = teacherRepository.save(teacherEntity);
        assertNotNull(savedTeacherEntity);
        teacherEntityEntities = teacherRepository.findByEmail(EMAIL);
        assertEquals(1, teacherEntityEntities.size());
    }
}