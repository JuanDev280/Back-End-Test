package com.back.service;

import com.back.domain.Book;
import com.back.domain.RentBook;
import java.util.List;

public interface RentBookService {
    
    public List<RentBook> listRentBooks();
    public void save(RentBook rentBook);
    public void remove(RentBook rentBook);
    public RentBook findRentBook(RentBook rentBook);
}
