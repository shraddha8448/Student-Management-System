package com.student.Student.Management.System.service;

import com.student.Student.Management.System.dto.StudentDTO;
import com.student.Student.Management.System.modal.Student;
import com.student.Student.Management.System.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO mapToStudentDTO(Student student){

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudentName(student.getStudentName());
        studentDTO.setStudentAge(student.getStudentAge());
        studentDTO.setStudentEmail(student.getStudentEmail());
        studentDTO.setCourses(student.getCourses());
        studentDTO.setAddress(student.getAddress());

        return studentDTO;
    }

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = new Student(studentDTO);
        return mapToStudentDTO(studentRepository.save(student));
    }

    @Override
    public List<StudentDTO> getAllStudents() {

        List<Student> studentList = studentRepository.findAll();

        return studentList.stream().
                map(this::mapToStudentDTO).toList();
    }

    @Override
    public StudentDTO getStudentById(long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student not found"));
        return mapToStudentDTO(student);
    }


}
