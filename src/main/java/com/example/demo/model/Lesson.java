package com.example.demo.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lesson_date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false, length = 50)
    private String room;

    @Column(name = "group_name", nullable = false, length = 50)
    private String groupName;

    @Column(name = "subject_name", nullable = false, length = 100)
    private String subjectName;

    @Column(nullable = false, length = 100)
    private String teacher;

    @Enumerated(EnumType.STRING)
    @Column(name = "lesson_type", nullable = false, length = 20)
    private LessonType type;

    // JPA потребує конструктора без параметрів
    public Lesson() {
    }

    public Lesson(
            LocalDateTime dateTime,
            String room,
            String groupName,
            String subjectName,
            String teacher,
            LessonType type
    ) {
        this.dateTime = dateTime;
        this.room = room;
        this.groupName = groupName;
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public LessonType getType() {
        return type;
    }

    public void setType(LessonType type) {
        this.type = type;
    }
}