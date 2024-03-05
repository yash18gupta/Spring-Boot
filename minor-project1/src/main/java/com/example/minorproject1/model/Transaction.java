package com.example.minorproject1.model;

import com.example.minorproject1.model.enums.TransactionStatus;
import com.example.minorproject1.model.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String externalTxnId;

    @CreationTimestamp
    private Date transactionTime;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;
    
    @ManyToOne
    @JoinColumn
    private Student student;
    
    @ManyToOne
    @JoinColumn
    private Book book;

    private Double fine;
}
