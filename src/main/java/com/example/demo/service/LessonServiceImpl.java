package com.example.demo.service;



import com.example.demo.exception.LessonNotFoundException;
import com.example.demo.model.Lesson;
import com.example.demo.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Lesson create(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson getById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException(id));
    }

    @Override
    public List<Lesson> getAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson update(Long id, Lesson updatedLesson) {
        Lesson existingLesson = getById(id);

        existingLesson.setDateTime(updatedLesson.getDateTime());
        existingLesson.setRoom(updatedLesson.getRoom());
        existingLesson.setGroupName(updatedLesson.getGroupName());
        existingLesson.setSubjectName(updatedLesson.getSubjectName());
        existingLesson.setTeacher(updatedLesson.getTeacher());
        existingLesson.setType(updatedLesson.getType());

        return lessonRepository.save(existingLesson);
    }

    @Override
    public void deleteById(Long id) {
        Lesson lesson = getById(id);
        lessonRepository.delete(lesson);
    }

    @Override
    public void deleteAll() {
        lessonRepository.deleteAll();
    }

    @Override
    public List<Lesson> findByDateTime(LocalDateTime dateTime) {
        return lessonRepository.findByDateTime(dateTime);
    }

    @Override
    public List<Lesson> findByRoom(String room) {
        return lessonRepository.findByRoomIgnoreCase(room);
    }

    @Override
    public List<Lesson> findByGroupName(String groupName) {
        return lessonRepository.findByGroupNameIgnoreCase(groupName);
    }

    @Override
    public List<Lesson> findBySubjectName(String subjectName) {
        return lessonRepository.findBySubjectNameIgnoreCase(subjectName);
    }

    @Override
    public List<Lesson> findByTeacher(String teacher, String groupName) {
        if (groupName == null || groupName.isBlank()) {
            return lessonRepository.findByTeacherIgnoreCase(teacher);
        }

        return lessonRepository
                .findByTeacherIgnoreCaseAndGroupNameIgnoreCase(teacher, groupName);
    }
}