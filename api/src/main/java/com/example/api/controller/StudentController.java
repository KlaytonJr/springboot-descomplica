package com.example.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entity.Student;
import com.example.api.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public Page<Student> getAllStudents(
        @RequestParam(defaultValue="0") Integer page, 
        @RequestParam(defaultValue="5") Integer itemsPerPage
    ) {
        return studentService.getAllStudents(PageRequest.of(page, itemsPerPage));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

}
