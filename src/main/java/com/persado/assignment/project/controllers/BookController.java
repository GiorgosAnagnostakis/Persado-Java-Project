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


    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }


    @RequestMapping({"", "/", "/index"})
    public String greeting() {
        return "welcome";
    }


    @RequestMapping(path = "/newBook", method = RequestMethod.POST)
    public String saveProduct(Book book) {
        //bookRepository.save(book);
        bookService.saveBook(book);
        System.out.println("hello"); //toBeDeleted
        return "redirect:/";
    }

    @RequestMapping(path = "/newBook", method = RequestMethod.GET)
    public String createProduct(Model model) {
        model.addAttribute("book", new Book());
        return "newBook";
    }

}