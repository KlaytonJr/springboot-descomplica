package com.example.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.api.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByName(@Param("courseName") String courseName);

}
