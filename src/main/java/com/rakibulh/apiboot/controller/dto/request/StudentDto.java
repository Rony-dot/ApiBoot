package com.rakibulh.apiboot.controller.dto.request;

import com.rakibulh.apiboot.enums.Gender;
import com.rakibulh.apiboot.model.Address;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class StudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Address address;
    private String createdAt;
    private List<String> favouriteSubjects;
    private String totalSpentInBooks;
}
