package com.example.Project.controller;

import com.example.Project.entity.Course;
import com.example.Project.entity.Teacher;
import com.example.Project.entity.TeacherCourseMapping;
import com.example.Project.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/teachers")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> fetchTeachers(){
        return teacherService.fetchTeachers();
    }

    @PutMapping("/{id}")
    public Teacher updateTeacherById(@RequestBody Teacher teacher,@PathVariable("id") long teacherId){
        return teacherService.updateTeacherById(teacher, teacherId);
    }

    @PostMapping("/courses")
    public void mapTeacherToCourse(@RequestBody List<TeacherCourseMapping> teacherCourseMappings){
        teacherService.mapTeacherToCourse(teacherCourseMappings);
    }

    @GetMapping("/courses")
    public List<Course> fetchCoursesByTeacher(@RequestParam("teacher_name") String teacherName){
        return teacherService.fetchCoursesByTeacher(teacherName);
    }
}
