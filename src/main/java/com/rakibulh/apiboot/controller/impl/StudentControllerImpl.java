package com.rakibulh.apiboot.controller.impl;

import com.rakibulh.apiboot.controller.StudentController;
import com.rakibulh.apiboot.model.Student;
import com.rakibulh.apiboot.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentControllerImpl implements StudentController {
    StudentService studentService;

    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    public ResponseEntity<List<Student>> getAllStudents(){
        var students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @Override
    public ResponseEntity<Student> getStudentByEmail(String email) {
        return ResponseEntity.ok(this.studentService.getStudentByEmail(email));
    }
}
