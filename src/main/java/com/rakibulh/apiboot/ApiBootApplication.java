package com.rakibulh.apiboot;

import com.rakibulh.apiboot.enums.Gender;
import com.rakibulh.apiboot.exception.ResourceAlreadyExistsException;
import com.rakibulh.apiboot.model.Address;
import com.rakibulh.apiboot.model.Student;
import com.rakibulh.apiboot.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class ApiBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBootApplication.class, args);
    }

    @Bean
    CommandLineRunner runner (StudentRepository studentRepository, MongoTemplate mongoTemplate){
        return args -> {
            Address kochuAddress = new Address("BD","1213","Dhaka");

            Student  kochuStudent = new Student("Mr kochu",
                    "Mochu",
                    "kochu@gmail.com",
                    Gender.MALE,
                    kochuAddress,
                    List.of("Database","Networking","OOP"),
                    BigDecimal.valueOf(1477.33) );

//            MongoTemplateWithQuery(studentRepository, mongoTemplate, kochuStudent);
//            String testEmail = "kochu@gmail.com";
            studentRepository.findStudentByEmail(kochuStudent.getEmail())
                    .ifPresentOrElse(s -> {
                        System.out.println("cannot insert student - Email existis");
                    }, () -> {
                        System.out.println("Student inserted: "+kochuStudent);
                        studentRepository.insert(kochuStudent);
                    });
        };
    }

    private static void MongoTemplateWithQuery(StudentRepository studentRepository, MongoTemplate mongoTemplate, Student kochuStudent) {


        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(kochuStudent.getEmail()));
        List<Student> students = mongoTemplate.find(query, Student.class);
        if(students.size() > 1){
            System.out.println("Student existis: "+kochuStudent);
            System.out.println("Total student found with this email: "+students.size());
            throw  new ResourceAlreadyExistsException("Student Already exists with this email: "+kochuStudent.getEmail());
        }

        if(students.isEmpty()){
            System.out.println("Student inserted: "+kochuStudent);
            studentRepository.insert(kochuStudent);
        }
        else{
            System.out.println("cannot insert student - Email existis");
        }
    }

}
