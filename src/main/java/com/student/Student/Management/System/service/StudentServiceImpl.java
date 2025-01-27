package com.student.Student.Management.System.service;

import com.student.Student.Management.System.dto.StudentDTO;
import com.student.Student.Management.System.exception.StudentNotFoundException;
import com.student.Student.Management.System.modal.Student;
import com.student.Student.Management.System.repository.StudentRepository;
import com.student.Student.Management.System.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    EmailService emailService;

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
        emailService.sendEmail(studentDTO.getStudentEmail(),"Added Successfully",student.toString());
        return mapToStudentDTO(studentRepository.save(student));
    }

    @Override
    public List<StudentDTO> getAllStudents() {

        List<Student> studentList = studentRepository.findAll();

        return studentList.stream().
                map(this::mapToStudentDTO).toList();
    }

    @Override
    public StudentDTO getStudentById(String studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new StudentNotFoundException("Student not found of studentId : "+ studentId));
        return mapToStudentDTO(student);
    }

    @Override
    public StudentDTO updateStudent(String studentId, StudentDTO studentDTO) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new StudentNotFoundException("Student not found of studentId : "+ studentId));

        student = new Student(studentDTO);
        student.setStudentId(studentId);
        return mapToStudentDTO(studentRepository.save(student));
    }

    @Override
    public StudentDTO deleteStudent(String studentId) {

        Student student= studentRepository.findById(studentId).orElseThrow(()-> new StudentNotFoundException("Student not found of studentId :"+ studentId));
        studentRepository.deleteById(studentId);
        return mapToStudentDTO(student);
    }


}
