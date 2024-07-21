package com.API.book.BootRestBook.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer authorid;
    private Integer auhorage;
    private  String  first_name;
    private String last_name;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private  Book book;

    public Author(Integer authorid, Integer auhorage, String first_name, String last_name,Book book) {
        this.authorid = authorid;
        this.auhorage = auhorage;
        this.first_name = first_name;
        this.last_name = last_name;
        this.book=book;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public Integer getAuhorage() {
        return auhorage;
    }

    public void setAuhorage(Integer auhorage) {
        this.auhorage = auhorage;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author() {

    }
}
