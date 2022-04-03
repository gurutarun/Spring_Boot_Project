package com.example.Project.dto;

import com.example.Project.entity.Course;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentCourseDto {

    private List<Course> studentCourse;
}
