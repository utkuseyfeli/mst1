package com.example.mst1.repo;

import com.example.mst1.model.Lesson;
import com.example.mst1.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepo extends MongoRepository<Teacher, String> {

        Optional<Teacher> findByNameAndSurname(String name, String surname);

        Optional<Teacher> getById(String id);

        @Override
        void deleteById(String s);

}
