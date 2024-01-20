package com.Lakshmi.PatientAppointments.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long medicationId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String patientName;
    @Column(nullable = false)
    private String doctorName;


}
