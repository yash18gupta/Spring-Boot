package com.example.minorproject1.model;
import com.example.minorproject1.model.enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private Integer pages;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactionList;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Student student;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
