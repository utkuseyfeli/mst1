package com.example.mst1.controllers;

import com.example.mst1.model.Lesson;
import com.example.mst1.model.Student;
import com.example.mst1.model.Teacher;
import com.example.mst1.services.LessonService;
import com.example.mst1.services.StudentService;
import com.example.mst1.services.TeacherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@AllArgsConstructor // bu autowired yapıyor mu
@RestController
public class Controller {

    StudentService studentService;
    LessonService lessonService;
    TeacherService teacherService;

    @PostMapping("/connectService") // burası
    public void connectString(@RequestBody String ids){
        String id[] = ids.split("-");
        Student student;
        Lesson lesson;

        System.out.println(Arrays.toString(id));

        Optional<Student> student1 = studentService.findStudent(id[0]);
        if(student1.isPresent()){
            student = student1.get();
        }else{
            System.out.println("student does not exist");
            return;
        }

        Optional<Lesson> lesson1 = lessonService.findLesson(id[1]);
        if(lesson1.isPresent()){
            lesson = lesson1.get();
        }else{
            System.out.println("lesson does not exist");
            return;
        }

        // Rest of the logic
        List<Lesson> lessons = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        lessons = student.getClasses();
        //System.out.println(lessons.toString());

        if(lessons == null){
            lessons = new ArrayList<>();
            lessons.add(lesson);
            student.setClasses(lessons);
            System.out.println("buralar 1");

        }else{
            lessons.add(lesson);
            student.setClasses(lessons);
            System.out.println("buralar 2");
        }

        //update student object in here for the database
        studentService.updateStudent(student);
    }

    @PostMapping("/connect")
    public void connect(@RequestBody JsonNode[] objects) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        // get the student
        Student student = mapper.treeToValue(objects[0], Student.class);
        Optional<Student> student1 = studentService.findStudent(student.getStudentId());
        if(student1.isPresent()){
            student = student1.get();
        }else{
            System.out.println("student does not exist");
            return;
        }

        // get the lesson
        Lesson lesson = mapper.treeToValue(objects[1], Lesson.class);
        Optional<Lesson> lesson1 = lessonService.findLesson(lesson.getLessonId());
        if(lesson1.isPresent()){
            lesson = lesson1.get();
        }else{
            System.out.println("lesson does not exist");
            return;
        }

        System.out.println("-------------------------------------------------------");
        System.out.println(student.toString());
        System.out.println(lesson.toString());
        System.out.println("-------------------------------------------------------");

        List<Lesson> lessons = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        lessons = student.getClasses();
        //System.out.println(lessons.toString());

        if(lessons == null){
            lessons = new ArrayList<>();
            lessons.add(lesson);
            student.setClasses(lessons);
            System.out.println("buralar 1");

        }else{
            lessons.add(lesson);
            student.setClasses(lessons);
            System.out.println("buralar 2");
        }
        
        //update student object in here for the database
        studentService.updateStudent(student);

    }

//    @PostMapping("/connect2")
//    public void complicatedConnect(@RequestBody JsonNode[] objects) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        Lesson lesson = mapper.treeToValue(objects[1], Lesson.class);
//        Teacher teacher = mapper.treeToValue(objects[0], Teacher.class);
//
//        Optional<Lesson> lesson1 = lessonService.findLesson(lesson.getLessonId());
//        if(lesson1.isPresent()){
//            lesson = lesson1.get();
//        }else{
//            System.out.println("lesson does not exist");
//            return;
//        }
//
//        Optional<Teacher> teacher1 = teacherController.getTeacher(teacher.getId());
//        if(teacher1.isPresent()){
//            teacher = teacher1.get();
//        }else{
//            System.out.println("teacher does not exist");
//            return;
//        }
//
//        System.out.println("-------------------------------------------------------");
//        System.out.println(teacher.toString());
//        System.out.println(lesson.toString());
//        System.out.println("-------------------------------------------------------");
//
//        List<Teacher> teachers = new ArrayList<>();
//        List<Lesson> lessons = new ArrayList<>();
//
//        lessons = teacher.getLessons();
//        teachers = lesson.getTeacher();
//
//        if(teachers == null && lessons == null){
//            System.out.println("buraya giriyor olmalı");
//            lessons = new ArrayList<>();
//            teachers = new ArrayList<>();
//        }else if(teachers == null && lessons != null){
//            teachers = new ArrayList<>();
//        }else if(lessons == null && teachers != null){
//            lessons = new ArrayList<>();
//        }else{
//        }
//
//        teachers.add(teacher);
//        lessons.add(lesson);
//
//        teacher.setLessons(lessons);
//        lesson.setTeacher(teachers);
//        System.out.println("burda mı");
//
//        System.out.println(teacher.toString());
//        teacherController.updateTeacher(teacher);
//        System.out.println("cikis");
//        lessonService.updateLesson(lesson);
//    }

    @PostMapping("/connectComplex") // bir de burası
    public void connectComplex(@RequestBody String ids){
        String id[] = ids.split("-");
        Teacher teacher;
        Lesson lesson;

        System.out.println(Arrays.toString(id));

        Optional<Teacher> teacher1 = teacherService.getTeacher(id[0]);
        if(teacher1.isPresent()){
            teacher = teacher1.get();
        }else{
            System.out.println("teacher does not exist");
            return;
        }

        Optional<Lesson> lesson1 = lessonService.findLesson(id[1]);
        if(lesson1.isPresent()){
            lesson = lesson1.get();
        }else{
            System.out.println("lesson does not exist");
            return;
        }

        // rest of
        List<String> teachers = new ArrayList<>();
        List<String> lessons = new ArrayList<>();

        lessons = teacher.getLessonIds();
        teachers = lesson.getTeacherIds();

        if(teachers == null && lessons == null){
            System.out.println("buraya giriyor olmalı");
            lessons = new ArrayList<>();
            teachers = new ArrayList<>();
        }else if(teachers == null && lessons != null){
            teachers = new ArrayList<>();
        }else if(lessons == null && teachers != null){
            lessons = new ArrayList<>();
        }else{
        }

        teachers.add(teacher.getId());
        lessons.add(lesson.getLessonId());

        teacher.setLessonIds(lessons);
        lesson.setTeacherIds(teachers);
        System.out.println("burda mı");

        System.out.println(teacher.toString());
        teacherService.updateTeacher(teacher);
        System.out.println("cikis");
        lessonService.updateLesson(lesson);
    }

    @GetMapping("/complexQuery1")
    // deneme öğretmeninin verdiği derslerden kredisi 4den fazla olanlar
    public Iterable<Lesson> complexQuery(){
        Teacher teacher;
        Lesson lesson;
        Iterable<Lesson> lesson1 = null;

        Optional<Teacher> teacher1 = teacherService.findByNameAndSurname("Deneme", "Öğretmeni1");
        if(teacher1.isPresent()){
            teacher = teacher1.get();
        }else{
            System.out.println("teacher does not exist");
            return lesson1;
        }

        System.out.println(teacher);

        ArrayList<String> lssns = (ArrayList<String>) teacher.getLessonIds();

        System.out.println(lssns);

        lesson1 = lessonService.func1(lssns);

        System.out.println(lesson1);

        return lesson1;

    }
}
