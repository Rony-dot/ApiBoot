package com.rakibulh.apiboot.service;

import com.rakibulh.apiboot.exception.ResourceAlreadyExistsException;
import com.rakibulh.apiboot.exception.ResourceNotFoundException;
import com.rakibulh.apiboot.model.Student;
import com.rakibulh.apiboot.repo.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        List<Student> result = this.studentRepository.findAll();
        return result;
    }

    public Student getStudentByEmail(String email){
        return this.studentRepository.findStudentByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with this email"+email));
    }



}
