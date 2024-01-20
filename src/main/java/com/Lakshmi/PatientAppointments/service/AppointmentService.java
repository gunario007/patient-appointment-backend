package com.Lakshmi.PatientAppointments.service;

import com.Lakshmi.PatientAppointments.dto.AppointmentDto;
import com.Lakshmi.PatientAppointments.dto.PatientDto;

import java.util.List;

public interface AppointmentService  {

    AppointmentDto addAppointment(AppointmentDto appointmentDto);

    void deleteAppointment(Long appointmentId);

    AppointmentDto viewAppointmentById(Long appointmentId);
    AppointmentDto updateAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> viewAllAppointments();










}
