package com.persado.assignment.project.controllers;

// Created by Anagnostakis *\n \*/

import com.persado.assignment.project.model.Book;
import com.persado.assignment.project.repositories.BookRepository;
import com.persado.assignment.project.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;


    @RequestMapping(path = "/createNewBook", method = RequestMethod.GET)
    public String createNewBook(Model model) {
        model.addAttribute("book", new Book());
        return "createNewBook";
    }

    @RequestMapping(path = "/createNewBook", method = RequestMethod.POST)
    public String saveNewBook(Book book){
        bookService.saveBook(book);
        return "redirect:/";
    }

    @RequestMapping("/welcome")
    public String returnTo(Model model) {
        return "welcome";
    }






    @RequestMapping(path = "/createNewBook/welcome", method = RequestMethod.GET )
    public String welcomePage() {
        return "welcome";
    }




    @RequestMapping(path = "/newBook", method = RequestMethod.GET)
    public String createProduct(Model model) {
        model.addAttribute("book", new Book());
        return "newBook";
    }

    @RequestMapping(path = "/newBook", method = RequestMethod.POST)
    public String saveProduct(Book book) {
        //bookRepository.save(book);
        bookService.saveBook(book);
        System.out.println("hello"); //toBeDeleted
        return "redirect:/";
    }





    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }









}