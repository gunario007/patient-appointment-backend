package com.Lakshmi.PatientAppointments.controllers;

import com.Lakshmi.PatientAppointments.dto.AppointmentDto;
import com.Lakshmi.PatientAppointments.dto.MedicationDto;
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
        name = "CRUD API's for Medication Resource"

)

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MedicationController {

    private MedicationService medicationService;


    @Operation(
            summary = "Create Medication Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )


    @PostMapping("/medication/create")
    public ResponseEntity<MedicationDto> addAppointment(@RequestBody @Valid MedicationDto medicationDto){
        MedicationDto createAppointment= medicationService.addMedication(medicationDto);
        return new ResponseEntity<>(createAppointment, HttpStatus.CREATED);

    }

    @Operation(
            summary = "Get Medication Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )

    @GetMapping("/medication/{medicationId}")
    public ResponseEntity<MedicationDto> viewMedicationById(@PathVariable("medicationId") Long medicationId){
        MedicationDto medication=medicationService.viewMedicationById(medicationId);
        return new ResponseEntity<>(medication,HttpStatus.OK);
    }


    @Operation(
            summary = "Get All Medication Resources"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 OK"
    )

    @GetMapping("medications")
    public ResponseEntity<List<MedicationDto>> viewMedication(){
        List<MedicationDto> medications=medicationService.viewAllMedications();
        return new ResponseEntity<>(medications,HttpStatus.OK);
    }

    @Operation(
            summary = "Update an Medication Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )

    @PutMapping("/medication/{medicationId}")
    public ResponseEntity<MedicationDto> updateMedication(@PathVariable("medicationId") Long medicationId,
                                                            @RequestBody @Valid MedicationDto medicationDto){
        medicationDto.setMedicationId(medicationId);
        MedicationDto updatedMedication=medicationService.updateMedication(medicationDto);
        return new ResponseEntity<>(updatedMedication,HttpStatus.OK);

    }

    @Operation(
            summary = "Delete an Medication Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )

    @DeleteMapping("/medication/{medicationId}")
    public ResponseEntity<String> deleteMedication(@PathVariable("medicationId") Long medicationId){
        medicationService.deleteMedication(medicationId);
        return new ResponseEntity<>("Medication details deleted successfully", HttpStatus.NO_CONTENT);
    }

}
