package com.learning.studentmanagementsystem.service;

import com.learning.studentmanagementsystem.entity.Teacher;

import java.util.List;

/**
 * Created by dev-manojkumar007 on 20 Aug, 2021
 */
public interface TeacherService {

    public Teacher saveTeacher(Teacher teacher);
    public List<Teacher> saveTeachers(List<Teacher> teachers);
    public Teacher getTeacherById(int id);
    public List<Teacher> getAllTeachers();
    public List<Teacher> getTeacherByName(String name);
    public String deleteTeacher(int id);
    public Teacher updateTeacher(Teacher teacher);
}
