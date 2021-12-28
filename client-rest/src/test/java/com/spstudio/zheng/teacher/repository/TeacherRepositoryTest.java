package com.spstudio.zheng.teacher.repository;

import com.spstudio.zheng.teacher.entity.Teacher;
import com.spstudio.zheng.teacher.repository.TeacherRepository;
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
class TeacherRepositoryTest {

    private static final String EMAIL = "teacher@gmail.com";

    @Autowired
    TeacherRepository teacherRepository;

    @BeforeEach
    void before() {
        List<Teacher> teacherEntities = teacherRepository.findByEmail(EMAIL);
        teacherRepository.deleteAll(teacherEntities);
    }

    @Test
    void findAll() {
        List<Teacher> teacherEntities = teacherRepository.findByEmail(EMAIL);
        assertEquals(0, teacherEntities.size());
        Teacher teacher = new Teacher();
        teacher.setId(UUID.randomUUID().toString());
        teacher.setTeacherCode("TEST001");
        teacher.setTeacherName("teacher name");
        teacher.setEmail(EMAIL);
        teacher.setMobilePhone("7371002000");
        teacher.setEnabled(1);
        Teacher savedTeacher = teacherRepository.save(teacher);
        assertNotNull(savedTeacher);
        teacherEntities = teacherRepository.findByEmail(EMAIL);
        assertEquals(1, teacherEntities.size());
    }
}