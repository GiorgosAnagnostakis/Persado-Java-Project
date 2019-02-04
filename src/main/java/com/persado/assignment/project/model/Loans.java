package com.persado.assignment.project.model;

// Created by Anagnostakis *\n \*/

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "loanDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate loanDate;

    @Column(name = "returnDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate = null;

    @Column(name = "bookid")
    private Long bookid;

    @Column(name = "userid")
    private Long userid;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
