package com.crudapp.demo.service;

import com.crudapp.demo.model.BookType;

import java.util.List;

public interface BookTypeService {
    List<BookType> findBookTypeList();
    BookType getSingleBookType(Long id);
}
