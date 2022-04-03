package com.example.Project.service;

import com.example.Project.entity.Course;
import com.example.Project.entity.Teacher;
import com.example.Project.entity.TeacherCourseMapping;

import java.util.List;

public interface TeacherService {
    public Teacher saveTeacher(Teacher teacher);

    public List<Teacher> fetchTeachers();

    public Teacher updateTeacherById(Teacher teacher, long teacherId);

    public void mapTeacherToCourse(List<TeacherCourseMapping> teacherCourseMappings);

    public List<Course> fetchCoursesByTeacher(String teacherName);
}
