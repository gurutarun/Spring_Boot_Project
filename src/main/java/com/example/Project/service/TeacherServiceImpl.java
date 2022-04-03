package com.example.Project.service;

import com.example.Project.entity.Course;
import com.example.Project.entity.Teacher;
import com.example.Project.entity.TeacherCourseMapping;
import com.example.Project.repository.CourseRepository;
import com.example.Project.repository.TeacherCourseMappingRespository;
import com.example.Project.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherCourseMappingRespository teacherCourseMappingRespository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> fetchTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher updateTeacherById(Teacher teacher, long teacherId) {
        Teacher teacherDb = teacherRepository.findById(teacherId).get();
        if (Objects.nonNull(teacher.getTeacherName()) && !"".equalsIgnoreCase(teacher.getTeacherName())){
            teacherDb.setTeacherName(teacher.getTeacherName());
        }
        return teacherRepository.save(teacherDb);
    }

    @Override
    public void mapTeacherToCourse(List<TeacherCourseMapping> teacherCourseMappings) {
        for (TeacherCourseMapping teacherCourseMapping:
             teacherCourseMappings) {
            TeacherCourseMapping mapping = teacherCourseMappingRespository.findByTeacherIdAndCourseId(teacherCourseMapping.getTeacherId(), teacherCourseMapping.getCourseId());

            if (mapping != null){
                if (mapping.isStatus() != teacherCourseMapping.isStatus()){
                    mapping.setStatus(teacherCourseMapping.isStatus());
                    teacherCourseMappingRespository.save(mapping);
                }
            }
            else {
                teacherCourseMappingRespository.save(teacherCourseMapping);
            }
        }
    }

    @Override
    public List<Course> fetchCoursesByTeacher(String teacherName) {
        Teacher teacher = teacherRepository.findByTeacherName(teacherName);
        List<Course> courses = new ArrayList<>();
        if (Objects.nonNull(teacher)){
            List<TeacherCourseMapping> teacherCourseMappingList = teacherCourseMappingRespository.findByTeacherId(teacher.getTeacherId());
            if (teacherCourseMappingList.isEmpty() != true){
                for (TeacherCourseMapping teacherCourseMapping:
                     teacherCourseMappingList) {
                    courses.add(courseRepository.findById(teacherCourseMapping.getCourseId()).get());
                }
            }
        }
        return courses;
    }
}
