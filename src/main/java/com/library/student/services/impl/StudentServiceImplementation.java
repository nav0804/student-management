package com.library.student.services.impl;

import com.library.student.dto.StudentDto;
import com.library.student.models.Student;
import com.library.student.repository.StudentRepository;
import com.library.student.services.StudentService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {


    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> searchAll() {
        List <Student> allStuds = studentRepository.findAll();
        return allStuds.stream().map(this::modelToDto).toList();
    }

    public StudentDto modelToDto(Student s){
        return StudentDto.builder()
                .id(s.getId())
                .name(s.getName())
                .fathersName(s.getFathersName())
                .village(s.getVillage())
                .admissionDate(s.getAdmissionDate())
                .expiryDate(s.getExpiryDate())
                .phoneNumber(s.getPhoneNumber())
                .paymentStatus(s.getPaymentStatus())
                .seatNumber(s.getSeatNumber())
                .paymentMode(s.getPaymentMode())
                .paymentDate(s.getPaymentDate())
                .dues(s.getDues())
                .build();
    }

    @Override
    public StudentDto update(StudentDto sdo) {
        if(!ObjectUtils.isEmpty(sdo.getId())){
            Student s = studentRepository.getById(sdo.getId());

            if(ObjectUtils.isEmpty(s)){
                throw new EntityNotFoundException("No student of this id");
            }
            return save(sdo,s);
        }
        return save(sdo);


    }

    @Transactional
    public StudentDto save(StudentDto sdo, Student s){
        Student existingStudent = studentRepository.findByPhoneNumber(sdo.getPhoneNumber());
        if(!ObjectUtils.isEmpty(existingStudent)){
            throw new EntityExistsException("User already exists");
        }
        s = dtoToModel(sdo,s);
        s = studentRepository.save(s);
        return modelToDto(s);
    }

    public Student dtoToModel(StudentDto studentDto, Student student) {

        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setFathersName(studentDto.getFathersName());
        student.setVillage(studentDto.getVillage());
        student.setAdmissionDate(studentDto.getAdmissionDate());
        student.setExpiryDate(studentDto.getExpiryDate());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setPaymentStatus(studentDto.getPaymentStatus());
        student.setSeatNumber(studentDto.getSeatNumber());
        student.setPaymentMode(studentDto.getPaymentMode());
        student.setPaymentDate(studentDto.getPaymentDate());
        student.setDues(studentDto.getDues());

        return student;
    }

    @Override
    public StudentDto findById(Long id) {
        Student ans = studentRepository.getById(id);
        return modelToDto(ans);
    }

    @Override
    public StudentDto save(StudentDto sdo) {
        return save(sdo, new Student());
    }

    @Override
    public void delete(Long id) {
        Student s = studentRepository.getById(id);
        if(!ObjectUtils.isEmpty(s)){
            throw new EntityNotFoundException("Not found student to delete");
        }
        try{
            studentRepository.delete(s);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Already in use");
        }
    }
}
