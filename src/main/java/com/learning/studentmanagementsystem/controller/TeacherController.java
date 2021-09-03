package com.learning.studentmanagementsystem.controller;

import com.learning.studentmanagementsystem.entity.Teacher;
import com.learning.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dev-manojkumar007 on 20 Aug, 2021
 */
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) { return teacherService.saveTeacher(teacher); }

    @PostMapping("/addTeachers")
    public List<Teacher> addTeachers(@RequestBody List<Teacher> teachers) { return teacherService.saveTeachers(teachers); }

    @GetMapping("/teacher/{id}")
    public Teacher findTeacherById(@PathVariable int id) { return teacherService.getTeacherById(id); }

    @GetMapping("/teachers")
    public List<Teacher> findAllTeachers() { return teacherService.getAllTeachers(); }

    @GetMapping("/teachersByName/{name}")
    public List<Teacher> findTeachersByName(@PathVariable String name) { return teacherService.getTeacherByName(name); }

    @DeleteMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable int id) { return teacherService.deleteTeacher(id); }

    @PutMapping("/updateTeacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher) { return teacherService.updateTeacher(teacher); }

}
