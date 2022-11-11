package com.rakibulh.apiboot.service;

import com.rakibulh.apiboot.model.Student;
import com.rakibulh.apiboot.repo.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        List<Student> result = this.studentRepository.findAll();
        return result;
    }

}
