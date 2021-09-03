package com.learning.studentmanagementsystem.serviceImpl;

import com.learning.studentmanagementsystem.service.StudentService;
import com.learning.studentmanagementsystem.entity.Student;
import com.learning.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dev-manojkumar007 on 19 Aug, 2021
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> saveStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Student getStudentByRollNo(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentsByBranch(String branch) {
        return studentRepository.findByBranch(branch);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public String deleteStudent(int id) {
        studentRepository.deleteById(id);
        return "Student with Roll No : " + id + " deleted successfully.";
    }

    public Student updateStudent(Student student) {
        Student existingStudent = studentRepository.findById(student.getRollNo()).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setBranch((student.getBranch()));
        existingStudent.setBatchYear(student.getBatchYear());
        existingStudent.setTeachers(student.getTeachers());
        return studentRepository.save(existingStudent);
    }

}
