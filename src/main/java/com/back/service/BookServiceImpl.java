package com.back.service;

import com.back.dao.BookDAO;
import com.back.domain.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService{
    
    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Book> listBooks() {
        return (List<Book>) bookDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Book book) {
        bookDAO.save(book);
    }

    @Override
    @Transactional
    public void remove(Book book) {
        bookDAO.delete(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Book findBook(Book book) {
        return bookDAO.findById(book.getIsbn()).orElse(null);
    }
}
