package com.Lakshmi.PatientAppointments.controllers;

import com.Lakshmi.PatientAppointments.dto.DoctorDto;
import com.Lakshmi.PatientAppointments.dto.MedicationDto;
import com.Lakshmi.PatientAppointments.service.DoctorService;
import com.Lakshmi.PatientAppointments.service.MedicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD API's for Doctor Resource"

)

@RestController
@AllArgsConstructor
@RequestMapping("/api")

public class DoctorController {

    private DoctorService doctorService;


    @Operation(
            summary = "Create Doctor Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )

    @PostMapping("/doctor/create")
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody @Valid DoctorDto doctorDto){
        DoctorDto createDoctor= doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(createDoctor, HttpStatus.CREATED);

    }


    @Operation(
            summary = "Get Doctor Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable("doctorId") Long doctorId){
        DoctorDto doctor=doctorService.getDoctorById(doctorId);
        return new ResponseEntity<>(doctor,HttpStatus.OK);
    }


    @Operation(
            summary = "Get All Doctor Resources"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 OK"
    )

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDto>> getDoctor(){
        List<DoctorDto> doctors=doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors,HttpStatus.OK);
    }

    @Operation(
            summary = "Update an Doctor Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )

    @PutMapping("/doctor/{doctorId}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable("doctorId") Long doctorId,
                                                          @RequestBody @Valid DoctorDto doctorDto){
        doctorDto.setDoctorId(doctorId);
        DoctorDto updatedDoctor=doctorService.updateDoctor(doctorDto);
        return new ResponseEntity<>(updatedDoctor,HttpStatus.OK);

    }

    @Operation(
            summary = "Delete an Doctor Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )

    @DeleteMapping("/doctor/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("doctorId") Long doctorId){
        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>("Doctor details deleted successfully", HttpStatus.NO_CONTENT);
    }
}
