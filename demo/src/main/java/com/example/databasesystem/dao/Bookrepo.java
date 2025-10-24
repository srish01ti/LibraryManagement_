package com.example.databasesystem.dao;

import com.example.databasesystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {

    // for Search by title
    List<Book> findByTitleContainingIgnoreCase(String title);


    // for filter by author
    List<Book> findByAuthor(String author);

    // for filter by category
    List<Book> findByCategory(String category);

    // for filter by rating
    List<Book> findByRating(double rating);

    //for pagination and sorting
    Page<Book> findAll(Pageable pageable);

}