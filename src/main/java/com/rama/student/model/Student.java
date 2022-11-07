package com.rama.student.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String dept;
    private String gender;

}
