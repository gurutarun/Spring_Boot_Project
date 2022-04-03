package com.example.Project.repository;

import com.example.Project.entity.StudentCourseMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseMappingRepository extends JpaRepository<StudentCourseMapping, Long> {

    public StudentCourseMapping findByStudentIdAndCourseId(long studentId, long courseId);

    public List<StudentCourseMapping> findByCourseId(long courseId);

    public List<StudentCourseMapping> findByStudentId(long studentId);
}
