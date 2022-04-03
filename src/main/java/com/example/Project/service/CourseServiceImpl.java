package com.example.Project.service;

import com.example.Project.dto.StudentCourseDto;
import com.example.Project.entity.Student;
import com.example.Project.entity.StudentCourseMapping;
import com.example.Project.entity.Course;
import com.example.Project.repository.CourseRepository;
import com.example.Project.repository.StudentCourseMappingRepository;
import com.example.Project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    private StudentCourseMappingRepository studentCourseMappingRepository;

    @Autowired
    private StudentRepository studentRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentCourseMappingRepository studentCourseMappingRepository) {
        this.courseRepository = courseRepository;
        this.studentCourseMappingRepository = studentCourseMappingRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> fetchCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourseById(long courseId, Course course) {
        Course courseDb = courseRepository.findById(courseId).get();
        if (Objects.nonNull(course.getCourseName()) && !"".equalsIgnoreCase(course.getCourseName())){
            courseDb.setCourseName(course.getCourseName());
        }
        return courseRepository.save(courseDb);
    }

    @Override
    public void mapStudentToCourse(List<StudentCourseMapping> mappings) {
        for (StudentCourseMapping mapping :
                mappings) {
            StudentCourseMapping s = studentCourseMappingRepository.findByStudentIdAndCourseId(mapping.getStudentId(), mapping.getCourseId());

            if(s!=null){
                if(s.isStatus() != mapping.isStatus()){
                    s.setStatus(mapping.isStatus());
                    studentCourseMappingRepository.save(s);
                }
            }
            else{
                studentCourseMappingRepository.save(mapping);
            }
        }
    }

    @Override
    public List<StudentCourseMapping> fetchStudentsByCourse(long courseId) {
        return studentCourseMappingRepository.findByCourseId(courseId);
    }

    @Override
    public List<Course> fetchCoursesByStudent(String studentName) {
        Student student = studentRepository.findBystudentName(studentName);
        List<StudentCourseMapping> courseList;
        List<Course> courses = new ArrayList<>();
        if(Objects.nonNull(student)){
            courseList = studentCourseMappingRepository.findByStudentId(student.getStudentId());
            if (courseList.isEmpty()!=true){
                for (StudentCourseMapping course: courseList) {
                    courses.add(courseRepository.findById(course.getCourseId()).get());
                }
            }
        }
        return courses;
    }
}
