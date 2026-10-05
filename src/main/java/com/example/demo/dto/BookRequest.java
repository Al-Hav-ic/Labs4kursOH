package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record BookRequest(

        @NotBlank(message = "Назва книги обов'язкова")
        @Size(max = 200, message = "Назва не може бути довшою за 200 символів")
        String title,

        @NotBlank(message = "Автор книги обов'язковий")
        @Size(max = 150, message = "Ім'я автора не може бути довшим за 150 символів")
        String author,

        @Size(max = 20, message = "ISBN не може бути довшим за 20 символів")
        String isbn,

        @PositiveOrZero(message = "Рік видання не може бути від'ємним")
        Integer publicationYear,

        @Size(max = 100, message = "Жанр не може бути довшим за 100 символів")
        String genre,

        @Size(max = 150, message = "Назва видавництва не може бути довшою за 150 символів")
        String publisher,

        @Positive(message = "Кількість сторінок має бути більшою за нуль")
        Integer pageCount,

        boolean read
) {
}