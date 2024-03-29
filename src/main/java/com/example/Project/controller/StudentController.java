package com.example.Project.controller;

import com.example.Project.entity.Student;
import com.example.Project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> fetchStudentsList(){
        return studentService.fetchStudentsList();
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable("id") long studentId){
        return studentService.findStudentById(studentId);
    }

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable("id") long studentId, @RequestBody Student student){
        return studentService.updateStudentById(studentId, student);
    }

    @GetMapping("/name/{name}")
    public Student fetchStudentByName(@PathVariable("name") String studentName){
        return studentService.fetchStudentByName(studentName);
    }
}
