package com.example.demo.mapper;

import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.model.Book;

public final class BookMapper {

    private BookMapper() {
    }

    public static Book toEntity(BookRequest request) {
        return new Book(
                request.title(),
                request.author(),
                request.isbn(),
                request.publicationYear(),
                request.genre(),
                request.publisher(),
                request.pageCount(),
                request.read()
        );
    }

    public static BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublicationYear(),
                book.getGenre(),
                book.getPublisher(),
                book.getPageCount(),
                book.isRead()
        );
    }
}
//JSON від Postman
//    ↓
//BookRequest
//    ↓ валідація через @Valid
//BookMapper
//    ↓
//Book Entity
//    ↓
//BookService
//    ↓
//BookRepository
//    ↓
//Hibernate формує SQL
//    ↓
//MySQL зберігає рядок і генерує id
//    ↑
//Book Entity з id
//    ↑
//BookMapper
//    ↑
//BookResponse
//    ↑
//JSON-відповідь клієнту