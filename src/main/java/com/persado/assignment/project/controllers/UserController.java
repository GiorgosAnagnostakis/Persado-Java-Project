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
import org.springframework.web.bind.annotation.PathVariable;
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
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        return "createNewUser";
    }

    @RequestMapping(path = "/createNewUser", method = RequestMethod.POST)
    public String saveNewUser(User user){
        userRepository.save(user);
        return "redirect:/";
    }





    @RequestMapping(path = "/manageUsers", method = RequestMethod.GET)
    public String getBooks(Model model) {

        model.addAttribute("users", userRepository.findAll());
        //   model.addAttribute("users", userRepository.findAll());
        //System.out.println(loanRepository.findAll());
        //long id = 1;
       // loanRepository.countByIdEquals(id);
        //System.out.println(loanRepository.countByIdEquals(id));
       // System.out.println(loanRepository.countByIdEqualsAndReturnDateIsNotNull(id));
        return "manageUsers";
    }


    @RequestMapping(path = "/manageUsers/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(name = "id") Long id) {

        if  (loanRepository.countByUseridEqualsAndReturnDateIsNotNull(id)== 0) {
            System.out.println("hello");
            userRepository.deleteById(id);
        }
        return "redirect:/manageUsers";
    }




}
