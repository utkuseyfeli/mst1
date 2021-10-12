package com.example.mst1.services;

import com.example.mst1.model.Student;
import com.example.mst1.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    public StudentRepo objectRepo;

    public List<Student> findStudents(){
        return objectRepo.findAll();
    }

    public void createStudent(Student student){
        objectRepo.insert(student);
    }

    public Optional<Student> findStudent(String id) {
        return objectRepo.getStudentById(id);
    }

    public void updateStudent(Student student){
        System.out.println("burasu");
        Optional<Student> std = objectRepo.getStudentById(student.getStudentId());
        if(std.isPresent()){
            objectRepo.save(student);
        }
    }

    public void deleteByStudentId(String id){
        objectRepo.deleteById(id);
    }
}
