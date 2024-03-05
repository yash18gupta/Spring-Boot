package com.geeksforgeeks;

import jakarta.persistence.*;

@Entity
@Table(name="employee-annotation")
public class EmployeeAnnotation {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "salary")
    private int salary;


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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public EmployeeAnnotation(int id, String name, int salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public EmployeeAnnotation() {
        super();
    }
}
