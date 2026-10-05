package com.example.demo.controller;

import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(
            @Valid @RequestBody BookRequest request
    ) {
        Book savedBook = bookService.create(BookMapper.toEntity(request));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(BookMapper.toResponse(savedBook));
    }

    @GetMapping
    public List<BookResponse> getAll() {
        return toResponses(bookService.getAll());
    }

    @GetMapping("/{id}")
    public BookResponse getById(@PathVariable Long id) {
        return BookMapper.toResponse(bookService.getById(id));
    }

    @PutMapping("/{id}")
    public BookResponse update(
            @PathVariable Long id,
            @Valid @RequestBody BookRequest request
    ) {
        Book updatedBook = bookService.update(
                id,
                BookMapper.toEntity(request)
        );

        return BookMapper.toResponse(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        bookService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/title")
    public List<BookResponse> findByTitle(@RequestParam String title) {
        return toResponses(bookService.findByTitle(title));
    }

    @GetMapping("/search/author")
    public List<BookResponse> findByAuthor(@RequestParam String author) {
        return toResponses(bookService.findByAuthor(author));
    }

    @GetMapping("/search/genre")
    public List<BookResponse> findByGenre(@RequestParam String genre) {
        return toResponses(bookService.findByGenre(genre));
    }

    @GetMapping("/search/isbn")
    public List<BookResponse> findByIsbn(@RequestParam String isbn) {
        return toResponses(bookService.findByIsbn(isbn));
    }

    @GetMapping("/search/year")
    public List<BookResponse> findByPublicationYear(
            @RequestParam Integer year
    ) {
        return toResponses(bookService.findByPublicationYear(year));
    }

    @GetMapping("/search/read")
    public List<BookResponse> findByReadStatus(
            @RequestParam boolean read
    ) {
        return toResponses(bookService.findByReadStatus(read));
    }

    private List<BookResponse> toResponses(List<Book> books) {
        return books.stream()
                .map(BookMapper::toResponse)
                .toList();
    }
}