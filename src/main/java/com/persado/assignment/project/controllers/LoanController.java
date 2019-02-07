package com.persado.assignment.project.controllers;

// Created by Anagnostakis *\n \*/

import com.persado.assignment.project.model.Loans;
import com.persado.assignment.project.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoanController {

    @Autowired
    LoanRepository loanRepository;


    @RequestMapping(path = "/returnBook", method = RequestMethod.GET)
    public String getBooks(Model model) {

        List<Loans> list = new ArrayList<>();
        int i = 0;

        for (Loans loan : loanRepository.findAll())
            if (loan.getReturnDate()==(null)){

             list.add(i, loan);

            }

        model.addAttribute("books", list);


        return "returnBook";


    }

}
