package org.geeksforgeeks.SpringBoot_JPA.model;

public class CreateStudentRequest {
    private int id;
    private String name;
    private String username;
    private String domain;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public CreateStudentRequest(String name, String username, String domain, String rollNum) {
        super();
        this.name = name;
        this.username = username;
        this.domain = domain;
        this.rollNum = rollNum;
    }

    public CreateStudentRequest() {
        super();
    }
}
