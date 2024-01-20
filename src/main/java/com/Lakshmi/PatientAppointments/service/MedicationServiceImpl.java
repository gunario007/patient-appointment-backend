package com.Lakshmi.PatientAppointments.service;

import com.Lakshmi.PatientAppointments.dto.AppointmentDto;
import com.Lakshmi.PatientAppointments.dto.MedicationDto;
import com.Lakshmi.PatientAppointments.exception.ResourceNotFoundException;
import com.Lakshmi.PatientAppointments.models.Appointment;
import com.Lakshmi.PatientAppointments.models.Medication;
import com.Lakshmi.PatientAppointments.repository.MedicationRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class MedicationServiceImpl implements MedicationService{

    private ModelMapper modelMapper;
    private MedicationRepository medicationRepository;
    @Override
    public MedicationDto addMedication(MedicationDto medicationDto) {
        Medication medication=modelMapper.map(medicationDto, Medication.class);
        Medication createMedication=medicationRepository.save(medication);
        MedicationDto createMedicationDto=modelMapper.map(medication, MedicationDto.class);
        return createMedicationDto;
    }

    @Override
    public void deleteMedication(Long medicationId) {

        Medication existingMedication = medicationRepository.findById(medicationId).
                orElseThrow(()->new ResourceNotFoundException("medication","id",medicationId));
        medicationRepository.deleteById(existingMedication.getMedicationId());

    }

    @Override
    public MedicationDto viewMedicationById(Long medicationId) {
        Medication medication = medicationRepository.findById(medicationId)
                .orElseThrow(()->new ResourceNotFoundException("medication","id",medicationId));
        return modelMapper.map(medication,MedicationDto.class);
    }

    @Override
    public MedicationDto updateMedication(MedicationDto medicationDto) {
        Medication medication=modelMapper.map(medicationDto,Medication.class);


        Medication existingMedication= medicationRepository.findById(medication.getMedicationId()).
                orElseThrow(()->new ResourceNotFoundException("medication","id",medication.getMedicationId()));
        existingMedication.setName(medication.getName());
        existingMedication.setPatientName(medication.getPatientName());
        existingMedication.setDoctorName(medication.getDoctorName());
        Medication updatedMedication=medicationRepository.save(existingMedication);

        MedicationDto updatedMedicationDto=modelMapper.map(updatedMedication, MedicationDto.class);
        return updatedMedicationDto;
    }

    @Override
    public List<MedicationDto> viewAllMedications() {
        List<Medication> medications=medicationRepository.findAll();
        List<MedicationDto> medicationDtos= medications.stream().map(medication -> modelMapper.map(medication, MedicationDto.class)).collect(Collectors.toList());

        return medicationDtos;
    }
}
