package org.geeksforgeeks.SpringBoot_JPA.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student-data")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "rollNum")
    private String rollNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public Student(int id, String name, String email, String rollNum) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.rollNum = rollNum;
    }

    public Student() {
        super();
    }
}
