package com.learning.studentmanagementsystem.repository;

import com.learning.studentmanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dev-manojkumar007 on 20 Aug, 2021
 */
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    List<Teacher> findByName(String name);

}
