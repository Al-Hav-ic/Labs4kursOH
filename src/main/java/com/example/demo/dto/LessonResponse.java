package com.example.demo.dto;

import com.example.demo.model.LessonType;

import java.time.LocalDateTime;

public record LessonResponse(
        Long id,
        LocalDateTime dateTime,
        String room,
        String groupName,
        String subjectName,
        String teacher,
        LessonType type
) {
}