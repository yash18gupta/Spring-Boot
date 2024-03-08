package com.example.minorproject1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String contact;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> bookList;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactionList;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    private Date validity;

    @OneToOne
    @JoinColumn
    private SecuredUser securedUser;
}
