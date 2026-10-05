package com.example.demo.repository;


import com.example.demo.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    // Пошук за точною датою та часом
    List<Lesson> findByDateTime(LocalDateTime dateTime);

    // Пошук за аудиторією
    List<Lesson> findByRoomIgnoreCase(String room);

    // Пошук за групою
    List<Lesson> findByGroupNameIgnoreCase(String groupName);

    // Пошук за назвою предмета
    List<Lesson> findBySubjectNameIgnoreCase(String subjectName);

    // Пошук усіх занять викладача
    List<Lesson> findByTeacherIgnoreCase(String teacher);

    // Пошук занять викладача в конкретній групі
    List<Lesson> findByTeacherIgnoreCaseAndGroupNameIgnoreCase(
            String teacher,
            String groupName
    );
}