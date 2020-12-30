package com.crudapp.demo.repository;

import com.crudapp.demo.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    @Query(value = "SELECT * FROM book_table", nativeQuery = true)
    List<Book> findAllBooks();

    @Query(value = "SELECT * From book_table where book_type_blid=?", nativeQuery = true)
    List<Book> findBookByType(Long id);

    @Query(value = "SELECT * from book_table order by book_name asc", nativeQuery = true)
    List<Book> bookOrderAsc();

    @Query(value = "SELECT * from book_table order by book_name desc", nativeQuery = true)
    List<Book> bookOrderDsc();

    @Query(value = "SELECT * FROM book_table  WHERE book_name= ?", nativeQuery = true)
    List<Book> searchBookByName(String name);

//    @Modifying
//    @Query(value = "INSERT INTO book (book_name,register_date) VALUES (:book_name,:register_date)",nativeQuery = true)
//    void createBook(@Param("book_name") String book_name,@Param("register_date") String register_date);
}
