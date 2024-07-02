package com.example.api.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.api.entity.Course;
import com.example.api.entity.CourseEvaluation;
import com.example.api.entity.Student;
import com.example.api.repository.CourseEvaluationRepository;
import com.example.api.repository.CourseRepository;
import com.example.api.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseEvaluationService {

    private final CourseEvaluationRepository courseEvaluationRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public ResponseEntity<String> evaluate(Long studentId, String courseName, Integer evaluationGrade) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        if(!studentOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found!");
        }
       
        Optional<Course> courseOpt = courseRepository.findByName(courseName);
        if(!courseOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found!");
        }

        CourseEvaluation courseEvaluation = new CourseEvaluation();
        courseEvaluation.setStudent(studentOpt.get());
        courseEvaluation.setCourse(courseOpt.get());
        courseEvaluation.setEvaluationGrade(evaluationGrade);

        courseEvaluationRepository.save(courseEvaluation);
        return ResponseEntity.ok("Success on save evaluation!");
    }
}
