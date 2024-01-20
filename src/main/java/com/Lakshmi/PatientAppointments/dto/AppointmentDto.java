package com.Lakshmi.PatientAppointments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

    private Long appointmentId;
    private String doctorName;
    private String patientName;

    private LocalDateTime AppointmentTime;
}
