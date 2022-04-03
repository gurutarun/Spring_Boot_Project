package com.example.Project.controller;

import com.example.Project.entity.Student;
import com.example.Project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Student> fetchStudentsList(){
        return studentService.fetchStudentsList();
    }

    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable("id") long studentId){
        return studentService.findStudentById(studentId);
    }

    @PutMapping("/students/{id}")
    public Student updateStudentById(@PathVariable("id") long studentId, @RequestBody Student student){
        return studentService.updateStudentById(studentId, student);
    }

    @GetMapping("/students/name/{name}")
    public Student fetchStudentByName(@PathVariable("name") String studentName){
        return studentService.fetchStudentByName(studentName);
    }
}
