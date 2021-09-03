package com.learning.studentmanagementsystem.controller;

import com.learning.studentmanagementsystem.entity.Student;
import com.learning.studentmanagementsystem.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dev-manojkumar007 on 19 Aug, 2021
 */
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){ return studentServiceImpl.saveStudent(student); }

    @PostMapping("/addStudents")
    public List<Student> addStudents(@RequestBody List<Student> students) { return studentServiceImpl.saveStudents(students); }

    @GetMapping("/student")
    public List<Student> findAllStudents() { return studentServiceImpl.getAllStudents(); }

    @GetMapping("/student/{rollNo}")
    public Student findStudentByRollNo(@PathVariable int rollNo) { return studentServiceImpl.getStudentByRollNo(rollNo); }

    @GetMapping("/studentsByName/{name}")
    public List<Student> findStudentsByName(@PathVariable String name) { return studentServiceImpl.getStudentsByName(name); }

    @GetMapping("/studentsByBranch/{branch}")
    public List<Student> findStudentsByBranch(@PathVariable String branch) { return studentServiceImpl.getStudentsByBranch(branch); }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) { return studentServiceImpl.updateStudent(student); }

    @DeleteMapping("/deleteStudent/{rollNo}")
    public String deleteStudent(@PathVariable int rollNo) { return studentServiceImpl.deleteStudent(rollNo); }

}
