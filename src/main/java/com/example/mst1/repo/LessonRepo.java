package com.example.mst1.repo;

import com.example.mst1.model.Lesson;
import com.example.mst1.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface LessonRepo extends MongoRepository<Lesson, String> {

    @Query("{lessonId :?0}")
    Optional<Lesson> getLessonById(String id);

    @Override
    @Query("{credit: {$gt: ?0}}")
    Iterable<Lesson> findAllById(Iterable<String> strings);

//    List<Lesson> findAllLessonsByIdInCreditGreaterThan(List<String> ids, int credit);

    @Override
    void deleteById(String s);

//    ArrayList<Lesson> findAllById(ArrayList<String> ids);
}
