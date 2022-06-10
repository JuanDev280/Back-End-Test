package com.back.dao;

import com.back.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDAO extends CrudRepository<Book, Integer>{
}
