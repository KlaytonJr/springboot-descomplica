package com.example.api.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.api.entity.Book;
import com.example.api.entity.Student;
import com.example.api.repository.BookRepository;
import com.example.api.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;
    private BookRepository bookRepository;

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
        Set<Book> books = student.getBooks();
        student.setBooks(new HashSet<>());

        Student salvedStudent = studentRepository.save(student);

        for (Book book : books) {
            book.setStudent(Student.builder().id(student.getId()).build());
            student.getBooks().add(bookRepository.save(book));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(salvedStudent);
    }

    public ResponseEntity<Student> updateStudent(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            for (Book book : student.getBooks()) {
                book.setStudent(student);
            }
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
