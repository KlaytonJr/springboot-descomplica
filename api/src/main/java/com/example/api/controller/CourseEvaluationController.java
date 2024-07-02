package com.example.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.service.CourseEvaluationService;

import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
@RequestMapping("/evaluations")
public class CourseEvaluationController {

    private final CourseEvaluationService courseEvaluationService;

    @PostMapping
    public ResponseEntity<String> evaluate(
        @RequestParam Long studentId,
        @RequestParam String courseName,
        @RequestParam Integer evaluationGrade
    ) {
        return courseEvaluationService.evaluate(studentId, courseName, evaluationGrade);
    }
    
}
