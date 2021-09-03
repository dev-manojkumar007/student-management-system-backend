package com.learning.studentmanagementsystem.serviceImpl;

import com.learning.studentmanagementsystem.entity.Teacher;
import com.learning.studentmanagementsystem.repository.TeacherRepository;
import com.learning.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dev-manojkumar007 on 20 Aug, 2021
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher) { return teacherRepository.save(teacher); }

    public List<Teacher> saveTeachers(List<Teacher> teachers) { return teacherRepository.saveAll(teachers); }

    public Teacher getTeacherById(int id) { return teacherRepository.findById(id).orElse(null); }

    public List<Teacher> getAllTeachers() { return teacherRepository.findAll(); }

    public List<Teacher> getTeacherByName(String name) { return teacherRepository.findByName(name); }

    public String deleteTeacher(int id) {
        teacherRepository.deleteById(id);
        return "Teacher with ID : " + id + " deleted successfully.";
    }

    public Teacher updateTeacher(Teacher teacher) {
        Teacher existingTeacher = teacherRepository.findById(teacher.getId()).orElse(null);
        existingTeacher.setName(teacher.getName());
        existingTeacher.setExperience(teacher.getExperience());
        existingTeacher.setStudents(teacher.getStudents());

        return teacherRepository.save(existingTeacher);
    }

}
