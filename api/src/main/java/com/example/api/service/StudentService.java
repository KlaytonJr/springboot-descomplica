package com.example.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.api.entity.Student;

@Service
public class StudentService {

    private static Map<Long, Student> studentList = new HashMap<>();

    public ResponseEntity<Student> getStudentById(Long id) {
        Student student = studentList.get(id);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentList.values());
    }

    public ResponseEntity<Student> createStudent(Student student) {
        studentList.put(student.getId(), student);

        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    public ResponseEntity<Student> updateStudent(Student student) {
        Student studentFounded = studentList.get(student.getId());

        if (studentFounded == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        studentList.put(student.getId(), student);

        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    public ResponseEntity<String> deleteStudent(Long id) {
        Student studentFounded = studentList.get(id);

        if (studentFounded == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        studentList.remove(id);

        return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully!");
    }

}
