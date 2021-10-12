package com.example.mst1.services;

import com.example.mst1.model.Lesson;
import com.example.mst1.repo.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    public LessonRepo lessonRepo;

    public List<Lesson> findLessons() {
        return lessonRepo.findAll();
    }

    public void createLesson(Lesson lesson){
        lessonRepo.insert(lesson);
    }

    public Optional<Lesson> findLesson(String id){
        return lessonRepo.getLessonById(id);
    }

    public void updateLesson(Lesson lesson){

        System.out.println("burasu");
        Optional<Lesson> lsn = lessonRepo.getLessonById(lesson.getLessonId());

        if(lsn.isPresent()){
            lessonRepo.save(lesson);
        }
    }

    public void deleteLessonById(String id){
        lessonRepo.deleteById(id);
    }

    public Iterable<Lesson> func1(ArrayList<String> ids){
        return lessonRepo.findAllById(ids);
    }
}
