package com.Lakshmi.PatientAppointments.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDto {

    private Long medicationId;
    private String name;

    private String patientName;
    private String doctorName;

}
