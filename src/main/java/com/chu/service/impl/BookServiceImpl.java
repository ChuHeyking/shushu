package com.chu.service.impl;

import com.chu.dao.BookDao;
import com.chu.dao.RoleDao;
import com.chu.domain.Book;
import com.chu.domain.Role;
import com.chu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

/*    @Autowired
    private RoleDao roleDao;*/

    @Override
    public List<Book> findAll(String day) {
        return bookDao.findAll(day);
    }


}
