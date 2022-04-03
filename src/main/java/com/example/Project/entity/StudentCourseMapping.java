package com.example.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "student_course",
        uniqueConstraints = @UniqueConstraint(name = "uk_student_course_student_id_course_id",columnNames = {"student_id", "course_id"})
)
public class StudentCourseMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "course_id")
    private long courseId;
    private boolean status;
}
