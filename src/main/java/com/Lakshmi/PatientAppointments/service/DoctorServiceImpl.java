package com.Lakshmi.PatientAppointments.service;

import com.Lakshmi.PatientAppointments.dto.DoctorDto;
import com.Lakshmi.PatientAppointments.dto.PatientDto;
import com.Lakshmi.PatientAppointments.exception.ResourceNotFoundException;
import com.Lakshmi.PatientAppointments.models.Doctor;
import com.Lakshmi.PatientAppointments.models.Patient;
import com.Lakshmi.PatientAppointments.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService{

    private ModelMapper modelMapper;
    private DoctorRepository doctorRepository;
    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor=modelMapper.map(doctorDto, Doctor.class);
        Doctor createDoctor=doctorRepository.save(doctor);
        DoctorDto createDoctorDto=modelMapper.map(createDoctor, DoctorDto.class);
        return createDoctorDto;
    }

    @Override
    public DoctorDto getDoctorById(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(()->new ResourceNotFoundException("doctor","id",doctorId));
        return modelMapper.map(doctor,DoctorDto.class);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors=doctorRepository.findAll();
        List<DoctorDto> doctorDtos= doctors.stream().map(doctor -> modelMapper.map(doctor, DoctorDto.class)).collect(Collectors.toList());

        return doctorDtos;
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto) {
        Doctor doctor=modelMapper.map(doctorDto,Doctor.class);


        Doctor existingDoctor = doctorRepository.findById(doctor.getDoctorId()).
                orElseThrow(()->new ResourceNotFoundException("doctor","id",doctor.getDoctorId()));
        existingDoctor.setDoctorName(doctor.getDoctorName());
        existingDoctor.setSpecilisation(doctor.getSpecilisation());
        existingDoctor.setVisitingHoursFrom(doctor.getVisitingHoursFrom());
        existingDoctor.setVisitingHoursTo(doctor.getVisitingHoursTo());
        existingDoctor.setPatientList(doctor.getPatientList());

        Doctor updatedDoctor=doctorRepository.save(existingDoctor);

        DoctorDto updatedDoctorDto=modelMapper.map(updatedDoctor, DoctorDto.class);
        return updatedDoctorDto;
    }

    @Override
    public void deleteDoctor(Long doctorId) {

        Doctor existingDoctor = doctorRepository.findById(doctorId).
                orElseThrow(()->new ResourceNotFoundException("doctor","id",doctorId));

        doctorRepository.deleteById(existingDoctor.getDoctorId());

    }
}
