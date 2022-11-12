package com.rakibulh.apiboot.repo;

import com.rakibulh.apiboot.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// MongoRepository<Class er nam, Datatype for Student Id>
@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    Optional<Student> findStudentByEmail(String email);

//    @Override
//    public Boolean insert(Student student);
}
