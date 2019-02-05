package com.persado.assignment.project.services;

// Created by Anagnostakis *\n \*/

import com.persado.assignment.project.model.Book;

import java.util.List;

public interface BookService {

    Book saveBook (Book book);

    List<Book> booksOnLoan();


}
