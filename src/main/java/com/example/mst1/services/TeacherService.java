package com.example.mst1.services;

import com.example.mst1.model.Teacher;
import com.example.mst1.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    public TeacherRepo teacherRepo;

    public List<Teacher> getTeachers() {
        return teacherRepo.findAll();
    }

    public void createTeacher(Teacher teacher) {
        teacherRepo.insert(teacher);
    }

    public Optional<Teacher> getTeacher(String id){
        return teacherRepo.findById(id);
    }

    public void updateTeacher(Teacher teacher){
        System.out.println("burasu");
        Optional<Teacher> tchr = teacherRepo.getById(teacher.getId());
        System.out.println("burasu2");
        if(tchr.isPresent()){
            System.out.println(teacher.toString());
            teacherRepo.save(teacher);
        }
    }

    public void deleteByTeacherId(String id){
        teacherRepo.deleteById(id);
    }

    public Optional<Teacher> findByNameAndSurname(String name, String surname){
        return teacherRepo.findByNameAndSurname(name, surname);
    }
}
