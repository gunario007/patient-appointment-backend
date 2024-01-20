package com.Lakshmi.PatientAppointments.service;

import com.Lakshmi.PatientAppointments.dto.AppointmentDto;
import com.Lakshmi.PatientAppointments.dto.PatientDto;
import com.Lakshmi.PatientAppointments.exception.ResourceNotFoundException;
import com.Lakshmi.PatientAppointments.models.Appointment;
import com.Lakshmi.PatientAppointments.models.Patient;
import com.Lakshmi.PatientAppointments.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    private ModelMapper modelMapper;


    @Override
    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        Appointment appointment=modelMapper.map(appointmentDto,Appointment.class);
        Appointment createAppointment=appointmentRepository.save(appointment);
        AppointmentDto createAppointmentDto=modelMapper.map(appointment, AppointmentDto.class);
        return createAppointmentDto;
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
         Appointment existingAppointment = appointmentRepository.findById(appointmentId).
                orElseThrow(()->new ResourceNotFoundException("Appointment","id",appointmentId));
        appointmentRepository.deleteById(existingAppointment.getAppointmentId());
    }

    @Override
    public AppointmentDto viewAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(()->new ResourceNotFoundException("appointment","id",appointmentId));
        return modelMapper.map(appointment,AppointmentDto.class);
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto) {
        Appointment appointment=modelMapper.map(appointmentDto,Appointment.class);


        Appointment existingAppointment = appointmentRepository.findById(appointment.getAppointmentId()).
                orElseThrow(()->new ResourceNotFoundException("appointment","id",appointment.getAppointmentId()));
        existingAppointment.setDoctorName(appointment.getDoctorName());
        existingAppointment.setPatientName(appointment.getPatientName());
        existingAppointment.setAppointmentTime(appointment.getAppointmentTime());
        Appointment updatedAppointment=appointmentRepository.save(existingAppointment);

        AppointmentDto updatedAppointmentDto=modelMapper.map(updatedAppointment, AppointmentDto.class);
        return updatedAppointmentDto;
    }

    @Override
    public List<AppointmentDto> viewAllAppointments() {
        List<Appointment> appointments=appointmentRepository.findAll();
        List<AppointmentDto> appointmentDtos= appointments.stream().map(appointment -> modelMapper.map(appointment, AppointmentDto.class)).collect(Collectors.toList());

        return appointmentDtos;
    }
}
