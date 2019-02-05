package com.persado.assignment.project.repositories;

// Created by Anagnostakis *\n \*/

import com.persado.assignment.project.model.Book;
import com.persado.assignment.project.model.Loans;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

 Book findByCopiesAvailable(int id);

 Book findById(long id);
 Long countByIdEquals(long id);


// Book findAllByCopiesAvailableGreaterThan(int i);
 List<Book> findAllByCopiesAvailableGreaterThan(int i);



 //List<Book> findAllBy

 //Long countByIdEqualsAndCopiesAvailableEquals (long id, int i);

//boolean countByCopiesAvailableEqualsAndCopiesPurchased();
}
