package com.crudapp.demo.service;

import com.crudapp.demo.model.Book;
import com.crudapp.demo.model.BookType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookService {

    void createBook(Book book,Long id);
    Book getSingle(Long id);
    Book updateBook(Book book,Long id);
    void deleteBook(Long id);

    //Native
    List<Book> findAllBook(String name);
    List<Book>  findBookByType(Long id);
    List<Book> bookOrderAsc();
    List<Book> bookOrderDsc();



}
