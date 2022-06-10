package com.back.service;

import com.back.domain.Book;
import java.util.List;

public interface BookService {
    
    public List<Book> listBooks();
    public void save(Book book);
    public void remove(Book book);
    public Book findBook(Book book);
}
