package com.Lakshmi.PatientAppointments.service;

import com.Lakshmi.PatientAppointments.dto.AppointmentDto;
import com.Lakshmi.PatientAppointments.dto.MedicationDto;

import java.util.List;

public interface MedicationService {

    MedicationDto addMedication(MedicationDto medicationDto);

    void deleteMedication(Long medicationId);

    MedicationDto viewMedicationById(Long medicationId);
    MedicationDto updateMedication(MedicationDto medicationDto);

    List<MedicationDto> viewAllMedications();
}
