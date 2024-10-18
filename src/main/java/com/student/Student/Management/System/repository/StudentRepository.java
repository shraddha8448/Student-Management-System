package com.student.Student.Management.System.repository;

import com.student.Student.Management.System.modal.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,Long> {

}
