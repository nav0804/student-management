package com.library.student.repository;

import com.library.student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "Select * from student where id=:id",nativeQuery = true)
    Student getById(@Param("id") Long id);

//    @Query(value = "Select * from student where phoneNumber=?1")
    Student findByPhoneNumber(String phoneNumber);
}

