package com.example.mst1.controllers;

import com.example.mst1.model.Student;
import com.example.mst1.repo.StudentRepo;
import com.example.mst1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin // CORS problemini çözmek için
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudents")
    public List<Student> findStudents() {
        return studentService.findStudents();
    }

    @PostMapping(value = "/createStudent")
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @GetMapping("/getThis")
    public Optional<Student> findStudent(String id) {
        return studentService.findStudent(id);
    }

    public void updateStudent(Student student){
        studentService.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public void deleteByStudentId(@PathVariable("studentId") String id){
        studentService.deleteByStudentId(id);
    }
}
