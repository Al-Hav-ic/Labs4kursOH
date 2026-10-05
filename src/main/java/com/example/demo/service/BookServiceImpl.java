package com.example.demo.service;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book update(Long id, Book updatedBook) {
        Book existingBook = getById(id);

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setIsbn(updatedBook.getIsbn());
        existingBook.setPublicationYear(updatedBook.getPublicationYear());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setPublisher(updatedBook.getPublisher());
        existingBook.setPageCount(updatedBook.getPageCount());
        existingBook.setRead(updatedBook.isRead());

        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteById(Long id) {
        Book book = getById(id);
        bookRepository.delete(book);
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    @Override
    public List<Book> findByGenre(String genre) {
        return bookRepository.findByGenreIgnoreCase(genre);
    }

    @Override
    public List<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public List<Book> findByPublicationYear(Integer year) {
        return bookRepository.findByPublicationYear(year);
    }

    @Override
    public List<Book> findByReadStatus(boolean read) {
        return bookRepository.findByRead(read);
    }
}