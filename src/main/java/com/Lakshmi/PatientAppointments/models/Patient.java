package com.Lakshmi.PatientAppointments.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    @Column(nullable = false)
    private String patientName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Long contact;
    @Column(nullable = false)
    private String medicalHistory;



}
