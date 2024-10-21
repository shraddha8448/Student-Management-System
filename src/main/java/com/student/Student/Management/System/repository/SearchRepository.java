package com.student.Student.Management.System.repository;

import com.student.Student.Management.System.modal.Student;

import java.util.List;

public interface SearchRepository {

    List<Student> findByText(String text);
}
