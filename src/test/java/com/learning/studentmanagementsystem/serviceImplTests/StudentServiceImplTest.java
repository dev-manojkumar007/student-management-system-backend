package com.learning.studentmanagementsystem.serviceImplTests;

import com.learning.studentmanagementsystem.entity.Student;
import com.learning.studentmanagementsystem.repository.StudentRepository;
import com.learning.studentmanagementsystem.serviceImpl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

/**
 * Created by dev-manojkumar007 on 23 Aug, 2021
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @InjectMocks
    StudentServiceImpl studentService;

    @Mock
    StudentRepository studentRepository;

    @Test
    public void saveStudentTest() {
        Student demoStudent = new Student();
        demoStudent.setRollNo(1504310028);
        demoStudent.setName("Manoj Kumar");
        demoStudent.setBatchYear("2019");
        demoStudent.setBranch("CSE");

        when(studentRepository.save(demoStudent)).thenReturn(demoStudent);

        assertEquals("Manoj Kumar", studentService.saveStudent(demoStudent).getName());

    }

    @Test
    public void saveStudentsTest() {

        Student demoStudent1 = new Student();
        Student demoStudent2 = new Student();

        demoStudent1.setRollNo(1504310028);
        demoStudent1.setName("Manoj Kumar");
        demoStudent1.setBatchYear("2019");
        demoStudent1.setBranch("CSE");

        demoStudent2.setRollNo(1504310048);
        demoStudent2.setName("Rohit Shukla");
        demoStudent2.setBranch("CSE");
        demoStudent2.setBatchYear("2019");

        List<Student> studentList = Arrays.asList(demoStudent1,demoStudent2);

        when(studentRepository.saveAll(studentList)).thenReturn(studentList);

        assertEquals(2,studentService.saveStudents(studentList).size());

    }

    @Test
    public void getStudentByRollNoTest() {

        Student demoStudent = new Student();
        demoStudent.setRollNo(1504310028);
        demoStudent.setName("Manoj Kumar");
        demoStudent.setBatchYear("2019");
        demoStudent.setBranch("CSE");

        when(studentRepository.findById(1504310028)).thenReturn(Optional.of(demoStudent));

        assertEquals("CSE",studentService.getStudentByRollNo(1504310028).getBranch());

    }

    @Test
    public void getStudentsByNameTest() {

        Student demoStudent = new Student();
        demoStudent.setRollNo(1504310028);
        demoStudent.setName("Manoj Kumar");
        demoStudent.setBatchYear("2019");
        demoStudent.setBranch("CSE");

        when(studentRepository.findByName("Manoj Kumar")).thenReturn(Stream.of(demoStudent).collect(Collectors.toList()));

        assertEquals("Manoj Kumar",studentService.getStudentsByName("Manoj Kumar").get(0).getName());

    }

    @Test
    public void getStudentsByBranchTest() {

        Student demoStudent = new Student();
        demoStudent.setRollNo(1504310028);
        demoStudent.setName("Manoj Kumar");
        demoStudent.setBatchYear("2019");
        demoStudent.setBranch("CSE");

        when(studentRepository.findByBranch("CSE")).thenReturn(Stream.of(demoStudent).collect(Collectors.toList()));

        assertEquals("Manoj Kumar",studentService.getStudentsByBranch("CSE").get(0).getName());

    }

    @Test
    public void getAllStudentsTest() {

        Student demoStudent = new Student();
        demoStudent.setRollNo(1504310028);
        demoStudent.setName("Manoj Kumar");
        demoStudent.setBatchYear("2019");
        demoStudent.setBranch("CSE");

        when(studentRepository.findAll()).thenReturn(Stream.of(demoStudent).collect(Collectors.toList()));

        assertEquals(1,studentService.getAllStudents().size());
    }

    @Test
    public void deleteStudentTest() {

        doNothing().when(studentRepository).deleteById(1504310028);
        studentService.deleteStudent(1504310028);

    }

    @Test
    public void updateStudentTest() {

        Student demoStudent = new Student();
        demoStudent.setRollNo(1504310028);
        demoStudent.setName("Manoj Kumar");
        demoStudent.setBatchYear("2019");
        demoStudent.setBranch("CSE");

        when(studentRepository.save(demoStudent)).thenReturn(demoStudent);
        when(studentRepository.findById(1504310028)).thenReturn(Optional.of(demoStudent));

        assertEquals("Manoj Kumar", studentService.updateStudent(demoStudent).getName());

    }

}
