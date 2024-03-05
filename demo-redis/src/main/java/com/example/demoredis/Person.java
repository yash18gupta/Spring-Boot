package com.example.demoredis;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person implements Serializable {

    private int personId;
    private String name;
    private long age;
    private double creditScore;
    private boolean isNRI;
}
