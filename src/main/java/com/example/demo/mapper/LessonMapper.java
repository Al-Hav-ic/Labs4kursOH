package com.example.demo.mapper;

import com.example.demo.dto.LessonRequest;
import com.example.demo.dto.LessonResponse;
import com.example.demo.model.Lesson;

public final class LessonMapper {

    private LessonMapper() {
    }

    public static Lesson toEntity(LessonRequest request) {
        return new Lesson(
                request.dateTime(),
                request.room(),
                request.groupName(),
                request.subjectName(),
                request.teacher(),
                request.type()
        );
    }

    public static LessonResponse toResponse(Lesson lesson) {
        return new LessonResponse(
                lesson.getId(),
                lesson.getDateTime(),
                lesson.getRoom(),
                lesson.getGroupName(),
                lesson.getSubjectName(),
                lesson.getTeacher(),
                lesson.getType()
        );
    }
}