package com.example.mst1.controllers;

import com.example.mst1.model.Lesson;
import com.example.mst1.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class LessonController {

    private LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }


    @GetMapping("/getLessons")
    public List<Lesson> findLessons() {
        return lessonService.findLessons();
    }

    @PostMapping("/createLesson")
    public void createLesson(@RequestBody Lesson lesson){
        lessonService.createLesson(lesson);
    }

    public Optional<Lesson> findLesson(String id){
        return lessonService.findLesson(id);
    }

    public void updateLesson(Lesson lesson){
        lessonService.updateLesson(lesson);
    }

    @DeleteMapping("/deleteLesson/{lessonId}")
    public void deleteByLessonId(@PathVariable("lessonId") String id){
        lessonService.deleteLessonById(id);
    }
}
