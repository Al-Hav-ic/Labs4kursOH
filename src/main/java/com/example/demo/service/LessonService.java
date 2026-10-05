package com.example.demo.service;

import com.example.demo.model.Lesson;

import java.time.LocalDateTime;
import java.util.List;

public interface LessonService {

    Lesson create(Lesson lesson);

    Lesson getById(Long id);

    List<Lesson> getAll();

    Lesson update(Long id, Lesson lesson);

    void deleteById(Long id);

    void deleteAll();

    List<Lesson> findByDateTime(LocalDateTime dateTime);

    List<Lesson> findByRoom(String room);

    List<Lesson> findByGroupName(String groupName);

    List<Lesson> findBySubjectName(String subjectName);

    List<Lesson> findByTeacher(String teacher, String groupName);
}