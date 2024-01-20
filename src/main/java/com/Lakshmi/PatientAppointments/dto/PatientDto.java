package com.Lakshmi.PatientAppointments.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Long patientId;

    private String patientName;

    private String address;


    private Long contact;

    private String medicalHistory;
}
