package com.chu.service;

import com.chu.domain.Book;
import com.chu.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    List<Book> findAll(String day);

    //List<Role> findByBookId(String day);
}
