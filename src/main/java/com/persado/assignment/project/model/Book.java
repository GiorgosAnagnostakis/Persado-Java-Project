package com.persado.assignment.project.model;

// Created by Anagnostakis *\n \*/


import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "summary")
    private String summary;

    @Column (name = "ISBN")
    private String ISBN;

    @Column (name = "copiesPurchased")
    private int copiesPurchased;

    @Column (name = "copiesAvailable")
    private int copiesAvailable;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCopiesPurchased() {
        return copiesPurchased;
    }

    public void setCopiesPurchased(int copiesPurchased) {
        this.copiesPurchased = copiesPurchased;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }
}
