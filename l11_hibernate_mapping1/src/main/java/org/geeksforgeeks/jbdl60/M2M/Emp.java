package org.geeksforgeeks.jbdl60.M2M;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "emp_table")
public class Emp {
    @Id
    @Column(name = "emp_id")
    private int empID;

    private String EmpName;

    @ManyToMany
    private List<Project> projects;

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Emp(int empID, String empName, List<Project> projects) {
        super();
        this.empID = empID;
        EmpName = empName;
        this.projects = projects;
    }

    public Emp() {
        super();
    }
}
