package com.learning.studentmanagementsystem.serviceImplTests;

import com.learning.studentmanagementsystem.entity.Teacher;
import com.learning.studentmanagementsystem.repository.TeacherRepository;
import com.learning.studentmanagementsystem.serviceImpl.TeacherServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

/**
 * Created by dev-manojkumar007 on 24 Aug, 2021
 */
@RunWith(MockitoJUnitRunner.class)
public class TeacherServiceImplTest {

    @InjectMocks
    TeacherServiceImpl teacherService;

    @Mock
    TeacherRepository teacherRepository;

    @Test
    public void saveTeacherTest() {

        Teacher demoTeacher = new Teacher();
        demoTeacher.setId(2008);
        demoTeacher.setName("Sanjeev Kumar");
        demoTeacher.setExperience(5);

        when(teacherRepository.save(demoTeacher)).thenReturn(demoTeacher);

        assertEquals(5,teacherService.saveTeacher(demoTeacher).getExperience());
    }

    @Test
    public void saveTeachersTest() {

        Teacher demoTeacher1 = new Teacher();
        Teacher demoTeacher2 = new Teacher();

        demoTeacher1.setId(2008);
        demoTeacher1.setName("Sanjeev Kumar");
        demoTeacher1.setExperience(5);

        demoTeacher2.setId(3008);
        demoTeacher2.setName("Rakesh Khanna");
        demoTeacher2.setExperience(8);

        List<Teacher> demoTeachersList = Arrays.asList(demoTeacher1, demoTeacher2);

        when(teacherRepository.saveAll(demoTeachersList)).thenReturn(demoTeachersList);

        assertEquals(2, teacherService.saveTeachers(demoTeachersList).size());
    }

    @Test
    public void getTeacherByIdTest() {

        Teacher demoTeacher = new Teacher();
        demoTeacher.setId(2008);
        demoTeacher.setName("Sanjeev Kumar");
        demoTeacher.setExperience(5);

        when(teacherRepository.findById(2008)).thenReturn(Optional.of(demoTeacher));

        assertEquals("Sanjeev Kumar",teacherService.getTeacherById(2008).getName());
    }

    @Test
    public void getAllTeachersTest() {

        Teacher demoTeacher = new Teacher();
        demoTeacher.setId(2008);
        demoTeacher.setName("Sanjeev Kumar");
        demoTeacher.setExperience(5);

        List<Teacher> demoTeachersList = Arrays.asList(demoTeacher);

        when(teacherRepository.findAll()).thenReturn(demoTeachersList);

        assertEquals(1,teacherService.getAllTeachers().size());

    }

    @Test
    public void getTeacherByNameTest() {

        Teacher demoTeacher = new Teacher();
        demoTeacher.setId(2008);
        demoTeacher.setName("Sanjeev Kumar");
        demoTeacher.setExperience(5);

        List<Teacher> demoTeachersList = Arrays.asList(demoTeacher);

        when(teacherRepository.findByName("Sanjeev Kumar")).thenReturn(demoTeachersList);

        assertEquals(1,teacherService.getTeacherByName("Sanjeev Kumar").size());
    }

    @Test
    public void deleteTeacherTest() {

        doNothing().when(teacherRepository).deleteById(2004);
        teacherService.deleteTeacher(2004);
    }

    @Test
    public void updateTeacherTest() {

        Teacher demoTeacher = new Teacher();
        demoTeacher.setId(2008);
        demoTeacher.setName("Sanjeev Kumar");
        demoTeacher.setExperience(5);

        when(teacherRepository.save(demoTeacher)).thenReturn(demoTeacher);
        when(teacherRepository.findById(2008)).thenReturn(Optional.of(demoTeacher));

        assertEquals("Sanjeev Kumar",teacherService.updateTeacher(demoTeacher).getName());

    }

}
