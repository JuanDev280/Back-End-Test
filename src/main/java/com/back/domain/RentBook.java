package com.back.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "rentbook")
public class RentBook implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date reservationDate;
    private Date returnDate;
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "isbn")
    private Book book;

    public RentBook() {
    }

    public RentBook(Integer id) {
        this.id = id;
    }
    
    public RentBook(Date reservationDate, Date returnDate, int quantity, Usuario usuario, Book book) {
        this.reservationDate = reservationDate;
        this.returnDate = returnDate;
        this.quantity = quantity;
        this.usuario = usuario;
        this.book = book;
    }
}
