package com.persado.assignment.project.repositories;

// Created by Anagnostakis *\n \*/

import com.persado.assignment.project.model.Loans;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface LoanRepository extends CrudRepository<Loans, Long> {

    Long countByIdEquals (Long id);


   // Long countByIdEqualsAndReturnDateIsNotNull(long id);

      Long countByUseridEqualsAndReturnDateIsNotNull(long id);



    //Long countByuseridEqualsAndReturnDateIsNull(long id);



}
