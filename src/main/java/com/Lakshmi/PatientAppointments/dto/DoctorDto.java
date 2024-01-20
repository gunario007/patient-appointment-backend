package com.Lakshmi.PatientAppointments.dto;

import com.Lakshmi.PatientAppointments.models.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private Long doctorId;

    private String doctorName;

    private String specilisation;

    private Date visitingHoursFrom;

    private Date visitingHoursTo;

    private List<Patient> patientList=new ArrayList<>();

}
