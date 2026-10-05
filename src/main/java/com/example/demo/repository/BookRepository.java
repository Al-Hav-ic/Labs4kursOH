package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Пошук книг за частиною назви, без урахування регістру
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Пошук книг за частиною імені автора
    List<Book> findByAuthorContainingIgnoreCase(String author);

    // Пошук за жанром
    List<Book> findByGenreIgnoreCase(String genre);

    // Пошук за ISBN
    List<Book> findByIsbn(String isbn);

    // Пошук за роком видання
    List<Book> findByPublicationYear(Integer publicationYear);

    // Пошук за статусом прочитання
    List<Book> findByRead(boolean read);
}