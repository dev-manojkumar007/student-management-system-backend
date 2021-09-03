package com.learning.studentmanagementsystem.repository;

import com.learning.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dev-manojkumar007 on 19 Aug, 2021
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);
    List<Student> findByBranch(String branch);

}
