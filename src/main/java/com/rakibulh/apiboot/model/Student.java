package com.rakibulh.apiboot.model;

import com.rakibulh.apiboot.enums.Gender;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private LocalDateTime createdAt;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;


    public Student(String firstName, String lastName, String email, Gender gender, Address address, LocalDateTime createdAt, List<String> favouriteSubjects, BigDecimal totalSpentInBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.createdAt = createdAt;
        this.favouriteSubjects = favouriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
    }
}
