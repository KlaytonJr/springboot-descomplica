package com.example.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.api.entity.Student;
import com.example.api.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public ResponseEntity<Student> getStudentById(Long id) {
        if (studentRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(studentRepository.findById(id).get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public Page<Student> getAllStudents(PageRequest page) {
        return studentRepository.findAll(page);
    }

    public ResponseEntity<Student> createStudent(Student student) {
        Student salvedStudent = studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvedStudent);
    }

    public ResponseEntity<Student> updateStudent(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            Student salvedStudent = studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.OK).body(salvedStudent);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public ResponseEntity<String> deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully!");
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }

}
