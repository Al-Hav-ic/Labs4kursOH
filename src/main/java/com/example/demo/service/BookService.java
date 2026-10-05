package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    Book getById(Long id);

    List<Book> getAll();

    Book update(Long id, Book updatedBook);

    void deleteById(Long id);

    void deleteAll();

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

    List<Book> findByIsbn(String isbn);

    List<Book> findByPublicationYear(Integer year);

    List<Book> findByReadStatus(boolean read);
}