package com.example.demo.dto;


import com.example.demo.model.LessonType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record LessonRequest(
        @NotNull
        LocalDateTime dateTime,

        @NotBlank
        String room,

        @NotBlank
        String groupName,

        @NotBlank
        String subjectName,

        @NotBlank
        String teacher,

        @NotNull
        LessonType type
) {
}