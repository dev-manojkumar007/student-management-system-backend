package com.learning.studentmanagementsystem.service;

import com.learning.studentmanagementsystem.entity.Student;
import java.util.List;

/**
 * Created by dev-manojkumar007 on 19 Aug, 2021
 */
public interface StudentService {

    public Student saveStudent(Student student);
    public List<Student> saveStudents(List<Student> students);
    public Student getStudentByRollNo(int id);
    public List<Student> getStudentsByName(String name);
    public List<Student> getStudentsByBranch(String branch);
    public List<Student> getAllStudents();
    public String deleteStudent(int id);
    public Student updateStudent(Student student);

}
