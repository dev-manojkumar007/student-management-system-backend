package com.learning.studentmanagementsystem.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by dev-manojkumar007 on 19 Aug, 2021
 */
@Data
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    private int id;
    private String name;
    private int experience;

    @ManyToMany(mappedBy = "teachers")
    private List<Student> students;
}
