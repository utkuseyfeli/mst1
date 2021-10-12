package com.example.mst1.repo;

import com.example.mst1.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {

    Optional<Student> findStudentByName(String name);

    @Query("{studentId :?0}")
    Optional<Student> getStudentById(String id);

    @Override
    void deleteById(String s);
}
