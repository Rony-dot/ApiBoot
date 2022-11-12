package com.rakibulh.apiboot.controller;

import com.rakibulh.apiboot.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/students")
public interface StudentController {

    @GetMapping("")
    ResponseEntity<List<Student>> getAllStudents();

    @GetMapping("/{email}")
    ResponseEntity<Student> getStudentByEmail(@PathVariable String email);

    @PostMapping("/add")
    ResponseEntity<Void> addStudent(@RequestBody Student student);


}
