package org.geeksforgeeks.jbdl60.M2M;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project_table")
public class Project {
    @Id
    @Column(name = "project_id")
    private int projectId;
    private String projectName;

    @ManyToMany(mappedBy = "projects")
    private List<Emp> emps;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Project(int projectId, String projectName, List<Emp> emps) {
        super();
        this.projectId = projectId;
        this.projectName = projectName;
        this.emps = emps;
    }

    public Project() {
        super();
    }
}
