package org.geekforgeeks.SpringBoot_Hibernate.Model;

public class CustomerCreateRequest {
    private int id;
    private String name;
    private String username;
    private String domain;
    private String address;


    public CustomerCreateRequest(String name, String username, String domain, String address) {
        super();
        this.name = name;
        this.username = username;
        this.domain = domain;
        this.address = address;
    }


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


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public CustomerCreateRequest() {
        super();
        // TODO Auto-generated constructor stub
    }
}
