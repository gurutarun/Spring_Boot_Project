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
        name = "teacher_course",
        uniqueConstraints = @UniqueConstraint(name = "uk_teacher_course_teacher_id_course_id", columnNames = {"teacher_id","course_id"})
)
public class TeacherCourseMapping {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "teacher_id")
    private long teacherId;

    @Column(name = "course_id")
    private long courseId;

    private boolean status;

}
