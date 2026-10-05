package com.example.demo.exception;


public class LessonNotFoundException extends RuntimeException {

    public LessonNotFoundException(Long id) {
        super("Заняття з id " + id + " не знайдено");
    }
}