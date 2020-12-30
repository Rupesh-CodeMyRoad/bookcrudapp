package com.crudapp.demo.controller;

import com.crudapp.demo.model.Role;
import com.crudapp.demo.model.User;
import com.crudapp.demo.service.BookService;
import com.crudapp.demo.service.BookTypeService;
import com.crudapp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller

public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookTypeService bookTypeService;

    @GetMapping(value = "/loginIndex")
    public String firstindex(Model model, @Param("name") String name) {
        model.addAttribute("bookTypeList",bookTypeService.findBookTypeList());
        model.addAttribute("bookList",bookService.findAllBook(name));
        model.addAttribute("name",name);
        return "loginIndex";
    }

    @GetMapping("/user/register")
    public String registerPage() {
        return "userRegister";
    }

    @PostMapping("/user/register")
    public String registerUser(@ModelAttribute User user){
        userService.registerUser(user);
        return "redirect:/register";
    }

    @GetMapping("/user/login")
    public String LoginPage() {
        return "login";
    }




}
