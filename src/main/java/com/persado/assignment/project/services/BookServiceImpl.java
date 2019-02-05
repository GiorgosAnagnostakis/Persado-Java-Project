package com.persado.assignment.project.services;

// Created by Anagnostakis *\n \*/

import com.persado.assignment.project.model.Book;
import com.persado.assignment.project.model.User;
import com.persado.assignment.project.repositories.BookRepository;
import com.persado.assignment.project.repositories.LoanRepository;
import com.persado.assignment.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements  BookService {

    @Autowired
    BookRepository bookRepository;


    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }



    public List<Book>  booksOnLoan (){
        List<Book> list = new ArrayList<>();
        int i = 0;

        for (Book book : bookRepository.findAll())
            if (book.getCopiesAvailable()<book.getCopiesPurchased()){

                book.getId(); //returns book id
                list.add(i, book);
                i++;
            }

        return list;
    }


}
