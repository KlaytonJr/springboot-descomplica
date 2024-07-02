package com.example.api.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseEvaluation {

    @EmbeddedId
    private CourseEvaluationKey id = new CourseEvaluationKey();

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name="student_id")
    Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name="course_id")
    Course course;

    int evaluationGrade;
}
