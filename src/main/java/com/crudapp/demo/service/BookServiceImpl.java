package com.crudapp.demo.service;

import com.crudapp.demo.model.Book;
import com.crudapp.demo.model.BookType;
import com.crudapp.demo.repository.BookRepo;
import com.crudapp.demo.repository.BookTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;



    @Autowired
    private BookTypeService bookTypeService;


    @Override
    public List<Book> findAllBook(String name) {
        if (name != null){
            return bookRepo.searchBookByName(name);
        }
        return bookRepo.findAllBooks();
    }

    @Override
    public List<Book> findBookByType(Long id) {
        return bookRepo.findBookByType(id);
    }

    @Override
    public List<Book> bookOrderAsc() {
        return bookRepo.bookOrderAsc();
    }

    @Override
    public List<Book> bookOrderDsc() {
        return bookRepo.bookOrderDsc();
    }


    @Override
    public void createBook(Book book,Long id) {

        BookType bookType = bookTypeService.getSingleBookType(id);
        Book book1 = new Book(book.getId(),book.getBookName(),book.getRegisterDate(),bookType);
        bookRepo.save(book1);
    }

    @Override
    public Book getSingle(Long id) {
        return bookRepo.getOne(id);
    }

    @Override
    public Book updateBook(Book book,Long id) {
        BookType bookType = bookTypeService.getSingleBookType(id);
        Book book1= new Book(book.getId(),book.getBookName(),book.getRegisterDate(),bookType);
        return bookRepo.save(book1);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}
