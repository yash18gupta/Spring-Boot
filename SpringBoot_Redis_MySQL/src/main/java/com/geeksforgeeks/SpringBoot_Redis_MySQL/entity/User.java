package com.geeksforgeeks.SpringBoot_Redis_MySQL.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "user_redis")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int followers;

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

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", followers=" + followers +
                '}';
    }

    public User(int id, String name, int followers) {
        super();
        this.id = id;
        this.name = name;
        this.followers = followers;
    }

    public User() {
        super();
    }
}
