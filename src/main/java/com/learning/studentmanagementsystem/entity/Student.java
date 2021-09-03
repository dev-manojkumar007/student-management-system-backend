package com.learning.studentmanagementsystem.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dev-manojkumar007 on 18 Aug, 2021
 */

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    private int rollNo;
    private String name;
    private String branch;
    private String batchYear;

    @ManyToMany
    @JoinTable(name = "students_teachers", joinColumns = @JoinColumn(name = "rollNo"),
    inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Teacher> teachers;
}
