package com.crudapp.demo.controller;

import com.crudapp.demo.model.Book;

import com.crudapp.demo.service.BookService;
import com.crudapp.demo.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class AdminController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookTypeService bookTypeService;


    @GetMapping(value = "/BookTypeList")
    public String bookList(Model model) {
        model.addAttribute("bookTypeList",bookTypeService.findBookTypeList());
        return "BookTypeList";
    }


    @GetMapping(value = "/createBook")
    public String createbook(Model model) {
        model.addAttribute("bookTypeList",bookTypeService.findBookTypeList());
        return "createBook";
    }

    @PostMapping("/save")
    //ModalAttibute same as RequestBody
    //Model help to send java content to html
    //model.addAttributes le html ma pathaunxa
    public String saveBook(@ModelAttribute Book book,@RequestParam Long blid){
       bookService.createBook(book,blid);
        return "redirect:/loginIndex";
    }

    @GetMapping("/edit/book/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("singleBook", bookService.getSingle(id));
        model.addAttribute("bookTypeList", bookTypeService.findBookTypeList());
        return "/editBook";
    }

    @GetMapping("/book/{id}")
    public String bookType(@PathVariable("id") Long id, Model model) {
        model.addAttribute("bookList",bookService.findBookByType(id));
        return "/BookTypeTable";
    }


    @GetMapping("/bookasc")
    public String bookAsc(Model model) {
        model.addAttribute("bookList",bookService.bookOrderAsc());
        return "bookasc";
    }

    @GetMapping("/bookdsc")
    public String bookDsc(Model model) {
        model.addAttribute("bookList",bookService.bookOrderDsc());
        return "bookdsc";
    }

    @PostMapping("/edit")
    //ModalAttibute same as RequestBody
    //Model help to send java content to html
    //model.addAttributes le html ma pathaunxa
    public String editsBook(@ModelAttribute Book book, @RequestParam Long blid){
        bookService.updateBook(book,blid);
        return "redirect:/loginIndex";
    }

    @GetMapping("/delete/book/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model,@Param("name")String name) {
        model.addAttribute("bookList", bookService.findAllBook(name));
        bookService.deleteBook(id);
        return "redirect:/loginIndex";
    }


}
