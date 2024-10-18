package com.student.Student.Management.System.dto;

import com.student.Student.Management.System.modal.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    @NotEmpty(message = "Student name should not be empty")
    private String studentName;

    @Min(value = 1, message = "Student age must be positive")
    private int studentAge;

    @Email(message = "Email should be valid")
    private String studentEmail;

    @NotEmpty(message = "Courses should not be empty")
    private List<String> courses;

    private Address address;

}
