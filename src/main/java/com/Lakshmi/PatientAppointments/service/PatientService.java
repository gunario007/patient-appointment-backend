package com.Lakshmi.PatientAppointments.service;

import com.Lakshmi.PatientAppointments.dto.PatientDto;
import com.Lakshmi.PatientAppointments.models.Patient;

import java.util.List;

public interface PatientService {
    PatientDto createUser(PatientDto patientDto);

    PatientDto getUserById(Long patientId);

    List<PatientDto> getAllUsers();

    PatientDto updateUser(PatientDto patientDto);

    void deleteUser(Long patientId);
}
