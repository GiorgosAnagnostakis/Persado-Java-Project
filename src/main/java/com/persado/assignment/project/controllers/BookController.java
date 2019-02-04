package com.persado.assignment.project.controllers;

// Created by Anagnostakis *\n \*/

import com.persado.assignment.project.model.Book;
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

import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LoanRepository loanRepository;


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

    //========Return button========//
    @RequestMapping("/welcome")
    public String returnTo(Model model) {
        return "welcome";
    }








  /*  @RequestMapping(path = "/createNewBook/welcome", method = RequestMethod.GET )
    public String welcomePage() {
        System.out.println("hello");
        return "welcome";
    }
*/


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





    @RequestMapping(path = "/books", method = RequestMethod.GET)
    public String getBooks1(Model model) {

        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("books", bookRepository.findAll());
     //   model.addAttribute("users", userRepository.findAll());
        //System.out.println(loanRepository.findAll());
        long id = 1;
       // loanRepository.countByIdEquals(id);
        //System.out.println(loanRepository.countByIdEquals(id));
       // System.out.println(loanRepository.countByIdEqualsAndReturnDateIsNotNull(id));
        return "books";
    }

    @RequestMapping(path = "/manageBooks", method = RequestMethod.GET)
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "manageBooks";
    }


    //=============delete book============
    @RequestMapping(path = "/manageBooks/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable(name = "id") long id) {

       Book book = bookRepository.findById(id);
       int i = book.getCopiesAvailable();
       int j = book.getCopiesPurchased();

       if (i==j) {
           System.out.println(book.getCopiesAvailable());
           bookRepository.deleteById(id);
       }

        return "redirect:/manageBooks";
    }



    @RequestMapping(path = "/loanBook", method = RequestMethod.GET)
    public String returnBooksLoan (Model model) {

        List<Book> Book = new ArrayList<>();


        int i=0;
        model.addAttribute("books", bookRepository.findAllByCopiesAvailableGreaterThan(i));
        model.addAttribute("users", userRepository.findAll());

        return "loanBook";
    }

    @RequestMapping(value={"/manageUsers/delete/{id}/{id2}"},  method = RequestMethod.GET)
    public String deleteBookTest(@PathVariable("id") String id,@PathVariable("id2") String id2) {
        System.out.println(id);
        System.out.println(id2);
        return "redirect:/manageBooks";
    }




}