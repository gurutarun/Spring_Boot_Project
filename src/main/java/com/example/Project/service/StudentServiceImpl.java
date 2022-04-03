package com.example.Project.service;

import com.example.Project.entity.Student;
import com.example.Project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentsList() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student updateStudentById(long studentId, Student student) {
        Student studentDb = studentRepository.findById(studentId).get();
        if (Objects.nonNull(student.getStudentName()) && !"".equalsIgnoreCase(student.getStudentName())){
            studentDb.setStudentName(student.getStudentName());
        }
        return studentRepository.save(studentDb);
    }

    @Override
    public Student fetchStudentByName(String studentName) {
        return studentRepository.findBystudentName(studentName);
    }

}
