package com.library.student.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StudentDto {
    private Long id;
    private String name;
    private String fathersName;
    private String village;
    private LocalDate admissionDate;
    private LocalDate expiryDate;
    private String phoneNumber;
    private String paymentStatus;
    private Integer seatNumber;
    private String paymentMode;
    private LocalDate paymentDate;
    private Double dues;

}
