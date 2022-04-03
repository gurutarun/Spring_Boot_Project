package com.example.Project.service;

import com.example.Project.entity.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> fetchStudentsList();

    public Student findStudentById(long studentId);

    public Student updateStudentById(long studentId, Student student);

    public Student fetchStudentByName(String studentName);
}
