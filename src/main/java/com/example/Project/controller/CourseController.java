package com.example.Project.controller;

import com.example.Project.dto.StudentCourseDto;
import com.example.Project.entity.StudentCourseMapping;
import com.example.Project.entity.Course;
import com.example.Project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/courses")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @GetMapping
    public List<Course> fetchCourses(){
        return courseService.fetchCourses();
    }

    @PutMapping("/{id}")
    public Course updateCourseById(@PathVariable("id") long courseId, @RequestBody Course course){
        return courseService.updateCourseById(courseId, course);
    }

    @PostMapping("/student")
    public void mapStudentToCourse(@RequestBody List<StudentCourseMapping> mappings){
        courseService.mapStudentToCourse(mappings);
    }

    @GetMapping("/{id}/students")
    public List<StudentCourseMapping> fetchStudentsByCourse(@PathVariable("id") long courseId){
        return courseService.fetchStudentsByCourse(courseId);
    }

    @GetMapping("/students")
    public List<Course> fetchCoursesByStudent(@RequestParam("student_name") String studentName){
        return courseService.fetchCoursesByStudent(studentName);
    }

}
