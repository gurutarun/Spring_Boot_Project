package com.example.Project.repository;

import com.example.Project.entity.TeacherCourseMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherCourseMappingRespository extends JpaRepository<TeacherCourseMapping, Long> {
    public TeacherCourseMapping findByTeacherIdAndCourseId(long teacherId, long courseId);

    public List<TeacherCourseMapping> findByTeacherId(long teacherId);
}
