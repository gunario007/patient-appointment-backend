package com.Lakshmi.PatientAppointments.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    @Column(nullable = false)
    private String doctorName;
    @Column(nullable = false)
    private String specilisation;
    @Column(nullable = false)
    private Date visitingHoursFrom;
    @Column(nullable = false)
    private Date visitingHoursTo;

    @OneToMany
    private List<Patient> patientList=new ArrayList<>();


}
