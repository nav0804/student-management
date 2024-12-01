package com.library.student.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "fathers_name")
    private String fathersName;

    private String village;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    private Double dues;


}
