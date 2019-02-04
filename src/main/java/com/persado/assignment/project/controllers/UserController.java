package com.persado.assignment.project.controllers;

// Created by Anagnostakis *\n \*/

import com.persado.assignment.project.model.Book;
import com.persado.assignment.project.model.User;
import com.persado.assignment.project.repositories.BookRepository;
import com.persado.assignment.project.repositories.LoanRepository;
import com.persado.assignment.project.repositories.UserRepository;
import com.persado.assignment.project.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LoanRepository loanRepository;


    @RequestMapping(path = "/createNewUser", method = RequestMethod.GET)
    public String createNewBook(Model model) {
        model.addAttribute("user", new User());
        return "createNewUser";
    }

    @RequestMapping(path = "/createNewUser", method = RequestMethod.POST)
    public String saveNewBook(User user){
        userRepository.save(user);
        return "redirect:/";
    }

   
}
