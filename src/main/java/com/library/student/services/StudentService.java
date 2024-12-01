package com.library.student.services;

import com.library.student.dto.StudentDto;

import java.util.*;

public interface StudentService {
    List<StudentDto>searchAll();
    StudentDto update(StudentDto sdo);
    StudentDto findById(Long id);
    StudentDto save(StudentDto sdo);
    void delete(Long id);
}
