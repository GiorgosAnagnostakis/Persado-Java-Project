package com.persado.assignment.project.services;

// Created by Anagnostakis *\n \*/

import com.persado.assignment.project.model.Book;
import com.persado.assignment.project.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements  BookService {

    @Autowired
    BookRepository bookRepository;


    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
