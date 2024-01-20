package com.Lakshmi.PatientAppointments.service;

import com.Lakshmi.PatientAppointments.dto.PatientDto;
import com.Lakshmi.PatientAppointments.exception.ResourceNotFoundException;
import com.Lakshmi.PatientAppointments.models.Patient;
import com.Lakshmi.PatientAppointments.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService{

    private ModelMapper modelMapper;
    private PatientRepository patientRepository;

    @Override
    public PatientDto createUser(PatientDto patientDto) {
        Patient user=modelMapper.map(patientDto,Patient.class);
        Patient createUser=patientRepository.save(user);
        PatientDto createUserDto=modelMapper.map(user, PatientDto.class);
        return createUserDto;
    }

    @Override
    public PatientDto getUserById(Long patientId) {
        Patient user = patientRepository.findById(patientId)
                .orElseThrow(()->new ResourceNotFoundException("patient","id",patientId));
        return modelMapper.map(user,PatientDto.class);
    }

    @Override
    public List<PatientDto> getAllUsers() {
        List<Patient> users=patientRepository.findAll();
        List<PatientDto> userDtos= users.stream().map(user -> modelMapper.map(user, PatientDto.class)).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public PatientDto updateUser(PatientDto patientDto) {

        Patient user=modelMapper.map(patientDto,Patient.class);


        Patient existingUser = patientRepository.findById(user.getPatientId()).
                orElseThrow(()->new ResourceNotFoundException("patient","id",user.getPatientId()));
        existingUser.setPatientName(user.getPatientName());


        existingUser.setAddress(user.getAddress());
        existingUser.setContact(user.getContact());
        existingUser.setMedicalHistory(user.getMedicalHistory());


        Patient updatedUser=patientRepository.save(existingUser);

//        UserDto updatedUserDto=UserMapper.mapToUserDto(updatedUser);
        PatientDto updatedUserDto=modelMapper.map(updatedUser, PatientDto.class);
        return updatedUserDto;
    }



    @Override
    public void deleteUser(Long patientId) {
        Patient existingUser = patientRepository.findById(patientId).
                orElseThrow(()->new ResourceNotFoundException("patient","id",patientId));

        patientRepository.deleteById(existingUser.getPatientId());

    }
}
