package com.library.digital.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String transactionId = UUID.randomUUID().toString();;
    private boolean isIssued;
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus status;
//    @ManyToOne
//    @JoinColumn
//    private Book book;
//
//    @ManyToOne
//    @JoinColumn
//    private Card card;

    private int fineAmount;

    private Date bookDueDate;

//    @CreationTimestamp
//    private Date createdOn;
//    @UpdateTimestamp
//    private Date updatedOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }
//
//    public Card getCard() {
//        return card;
//    }
//
//    public void setCard(Card card) {
//        this.card = card;
//    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Date getBookDueDate() {
        return bookDueDate;
    }

    public void setBookDueDate(Date bookDueDate) {
        this.bookDueDate = bookDueDate;
    }

//    public Date getCreatedOn() {
//        return createdOn;
//    }
//
//    public void setCreatedOn(Date createdOn) {
//        this.createdOn = createdOn;
//    }
//
//    public Date getUpdatedOn() {
//        return updatedOn;
//    }
//
//    public void setUpdatedOn(Date updatedOn) {
//        this.updatedOn = updatedOn;
//    }
}
