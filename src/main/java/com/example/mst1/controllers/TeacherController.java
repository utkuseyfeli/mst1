package com.example.mst1.controllers;

import com.example.mst1.model.Teacher;
import com.example.mst1.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/getTeachers")
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @PostMapping("/createTeacher")
    public void createTeacher(@RequestBody Teacher teacher) {
        teacherService.createTeacher(teacher);
    }

    @GetMapping("/getTeacher/{teacherId}")
    public Optional<Teacher> getTeacher(@PathVariable("teacherId") String id){
        return teacherService.getTeacher(id);
    }

    @DeleteMapping("/deleteTeacher/{teacherId}")
    public void deleteByTeacherId(@PathVariable("teacherId") String id){
        teacherService.deleteByTeacherId(id);
    }

    public void updateTeacher(Teacher teacher){
        teacherService.updateTeacher(teacher);
    }
}
