package org.geeksforgeeks.SpringBoot_JPA.model;

public class CreateStudentResponse {
    private int id;
    private String name;
    private String email;
    private String rollNum;
    private int status;
    private String message;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CreateStudentResponse(int id, String name, String email, String rollNum, int status, String message) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.rollNum = rollNum;
        this.status = status;
        this.message = message;
    }

    public CreateStudentResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public CreateStudentResponse() {
        super();
    }
}
