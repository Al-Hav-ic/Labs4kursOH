package com.example.demo.controller;

import com.example.demo.dto.LessonRequest;
import com.example.demo.dto.LessonResponse;
import com.example.demo.mapper.LessonMapper;
import com.example.demo.model.Lesson;
import com.example.demo.service.LessonService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping
    public ResponseEntity<LessonResponse> create(
            @Valid @RequestBody LessonRequest request
    ) {
        Lesson savedLesson = lessonService.create(LessonMapper.toEntity(request));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedLesson.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(LessonMapper.toResponse(savedLesson));
    }

    @GetMapping
    public List<LessonResponse> getAll() {
        return lessonService.getAll()
                .stream()
                .map(LessonMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public LessonResponse getById(@PathVariable Long id) {
        return LessonMapper.toResponse(lessonService.getById(id));
    }

    @PutMapping("/{id}")
    public LessonResponse update(
            @PathVariable Long id,
            @Valid @RequestBody LessonRequest request
    ) {
        Lesson updatedLesson = lessonService.update(
                id,
                LessonMapper.toEntity(request)
        );

        return LessonMapper.toResponse(updatedLesson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        lessonService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        lessonService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-date-time")
    public List<LessonResponse> findByDateTime(
            @RequestParam LocalDateTime dateTime
    ) {
        return lessonService.findByDateTime(dateTime)
                .stream()
                .map(LessonMapper::toResponse)
                .toList();
    }

    @GetMapping("/by-room")
    public List<LessonResponse> findByRoom(@RequestParam String room) {
        return lessonService.findByRoom(room)
                .stream()
                .map(LessonMapper::toResponse)
                .toList();
    }

    @GetMapping("/by-group")
    public List<LessonResponse> findByGroup(
            @RequestParam String groupName
    ) {
        return lessonService.findByGroupName(groupName)
                .stream()
                .map(LessonMapper::toResponse)
                .toList();
    }

    @GetMapping("/by-subject")
    public List<LessonResponse> findBySubject(
            @RequestParam String subjectName
    ) {
        return lessonService.findBySubjectName(subjectName)
                .stream()
                .map(LessonMapper::toResponse)
                .toList();
    }

    @GetMapping("/by-teacher")
    public List<LessonResponse> findByTeacher(
            @RequestParam String teacher,
            @RequestParam(required = false) String groupName
    ) {
        return lessonService.findByTeacher(teacher, groupName)
                .stream()
                .map(LessonMapper::toResponse)
                .toList();
    }
}