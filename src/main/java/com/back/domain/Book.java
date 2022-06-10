package com.back.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer isbn;
    private String title;
    private String author;
    private String category;
    private int availability;
    private float price;

    public Book() {
    }

    public Book(Integer isbn) {
        this.isbn = isbn;
    }

    public Book(Integer isbn, String title, String author, String category, int availability, float price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.availability = availability;
        this.price = price;
    }
    
    
    
}
