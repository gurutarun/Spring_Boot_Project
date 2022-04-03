package com.example.Project.repository;

import com.example.Project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findBystudentName(String studentName);
}
