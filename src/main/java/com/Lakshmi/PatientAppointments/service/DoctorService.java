package com.Lakshmi.PatientAppointments.service;

import com.Lakshmi.PatientAppointments.dto.DoctorDto;
import com.Lakshmi.PatientAppointments.dto.PatientDto;

import java.util.List;

public interface DoctorService {

    DoctorDto createDoctor(DoctorDto doctorDto);

    DoctorDto getDoctorById(Long doctorId);

    List<DoctorDto> getAllDoctors();

    DoctorDto updateDoctor(DoctorDto doctorDto);

    void deleteDoctor(Long doctorId);
}
