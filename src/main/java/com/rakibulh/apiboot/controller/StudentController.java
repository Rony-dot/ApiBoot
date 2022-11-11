package com.rakibulh.apiboot.controller;

import com.rakibulh.apiboot.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/api/v1/students")
public interface StudentController {

    @GetMapping("")
    ResponseEntity<List<Student>> getAllStudents();
}
