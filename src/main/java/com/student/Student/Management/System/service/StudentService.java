package com.student.Student.Management.System.service;

import com.student.Student.Management.System.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    public StudentDTO addStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(long studentId);

    //StudentDTO updateStudent(long studentId, StudentDTO studentDTO);
}
