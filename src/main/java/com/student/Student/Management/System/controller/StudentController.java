package com.student.Student.Management.System.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import com.student.Student.Management.System.dto.StudentDTO;
import com.student.Student.Management.System.modal.Student;
import com.student.Student.Management.System.repository.SearchRepository;
import com.student.Student.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.io.IOException;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SearchRepository searchRepository;

    @RequestMapping(value = "/")
    @ApiIgnore
    public void redirect(HttpServletResponse response)throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @PostMapping("/add")
    public StudentDTO addStudent(@Valid @RequestBody StudentDTO studentDTO){
        return studentService.addStudent(studentDTO);
    }

    @GetMapping("/getAllStudent")
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getById/{studentId}")
    public StudentDTO getStudentById(@PathVariable String studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/search/{text}")
    public List<Student> search(@PathVariable String text){
        return searchRepository.findByText(text);
    }


    @PutMapping("/update/{studentId}")
    public StudentDTO updateStudent(@PathVariable String studentId,@Valid @RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentId,studentDTO);
    }

    @DeleteMapping("/delete/{studentId}")
    public StudentDTO deleteStudent(@PathVariable String studentId){
        return studentService.deleteStudent(studentId);
    }

}
