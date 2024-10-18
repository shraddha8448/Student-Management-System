package com.student.Student.Management.System.modal;

import com.student.Student.Management.System.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "StudentInfo")
public class Student {

    @Id
    private long studentId;

    private String studentName;
    private int studentAge;
    private String studentEmail;
    private List<String> courses;
    private Address address;

    public Student(StudentDTO studentDTO){
        this.studentName = studentDTO.getStudentName();
        this.studentEmail = studentDTO.getStudentEmail();
        this.studentAge = studentDTO.getStudentAge();
        this.courses = studentDTO.getCourses();
        this.address = studentDTO.getAddress();
    }
}
