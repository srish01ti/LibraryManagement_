package com.example.databasesystem.service;


import com.example.databasesystem.dao.BookRepo;
import com.example.databasesystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;


    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }


    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }


    public Optional<Book> getBookById(Long id) {
        return bookRepo.findById(id);
    }


    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book does not exist with id: " + id));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setCategory(book.getCategory());
        existingBook.setPrice(book.getPrice());
        existingBook.setRating(book.getRating());
        existingBook.setPublishedDate(book.getPublishedDate());

        return bookRepo.save(existingBook);
    }


    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }


    public List<Book> findByTitle(String title) {
        return bookRepo.findByTitleContainingIgnoreCase(title);
    }


    public List<Book> findByAuthor(String author) {
        return bookRepo.findByAuthor(author);
    }


    public List<Book> findByCategory(String category) {
        return bookRepo.findByCategory(category);
    }


    public List<Book> findByRating(double rating) {
        return bookRepo.findByRating(rating);
    }

    public Page<Book> getBooks(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }
}