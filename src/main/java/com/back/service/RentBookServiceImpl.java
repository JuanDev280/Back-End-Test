package com.back.service;

import com.back.dao.RentBookDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.back.domain.Book;
import com.back.domain.RentBook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentBookServiceImpl implements RentBookService {
    
    @Autowired
    private RentBookDAO rentBookDAO;

    @Override
    @Transactional(readOnly = true)
    public List<RentBook> listRentBooks() {
        return (List<RentBook>) rentBookDAO.findAll();
    }

    @Override
    @Transactional
    public void save(RentBook rentBook) {
        rentBookDAO.save(rentBook);
    }

    @Override
    @Transactional
    public void remove(RentBook rentBook) {
        rentBookDAO.delete(rentBook);
    }

    @Override
    @Transactional(readOnly = true)
    public RentBook findRentBook(RentBook rentBook) {
        return rentBookDAO.findById(rentBook.getId()).orElse(null);
    }
    
}
