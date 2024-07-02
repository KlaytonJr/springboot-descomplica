package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.entity.CourseEvaluation;
import com.example.api.entity.CourseEvaluationKey;

@Repository
public interface CourseEvaluationRepository extends JpaRepository<CourseEvaluation, CourseEvaluationKey> {

}
