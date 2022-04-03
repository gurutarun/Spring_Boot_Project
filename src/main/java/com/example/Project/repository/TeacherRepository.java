package com.example.Project.repository;

import com.example.Project.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    public Teacher findByTeacherName(String teacherName);
}
