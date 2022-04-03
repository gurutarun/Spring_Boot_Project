package com.example.Project.service;

import com.example.Project.dto.StudentCourseDto;
import com.example.Project.entity.StudentCourseMapping;
import com.example.Project.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public Course saveCourse(Course course);

    public List<Course> fetchCourses();

    public Course updateCourseById(long courseId, Course course);

    public void mapStudentToCourse(List<StudentCourseMapping> mappings);

    public List<StudentCourseMapping> fetchStudentsByCourse(long courseId);

    public List<Course> fetchCoursesByStudent(String studentName);
}
