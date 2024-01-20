package com.Lakshmi.PatientAppointments.controllers;

import com.Lakshmi.PatientAppointments.dto.PatientDto;
import com.Lakshmi.PatientAppointments.models.Patient;
import com.Lakshmi.PatientAppointments.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD API's for Patient Resource"

)
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@AllArgsConstructor
@RequestMapping({"/api"})

public class PatientController {

    private PatientService patientService;

    @Operation(
            summary = "Create Patient Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )

    @PostMapping({"/patient/create"})
    public ResponseEntity<PatientDto> createdUser(@RequestBody @Valid PatientDto patientDto){
        PatientDto createUser= patientService.createUser(patientDto);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);

    }

    @Operation(
            summary = "Get Patient Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )

    @GetMapping({"/patient/{patientId}"})
    public ResponseEntity<PatientDto> getUserById(@PathVariable("patientId") Long patientId){
        PatientDto user=patientService.getUserById(patientId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Patient Resources"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 OK"
    )

    @GetMapping({"/patients"})
    public ResponseEntity<List<PatientDto>> getUser(){
        List<PatientDto> users=patientService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @Operation(
            summary = "Update an Patient Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )

    @PutMapping({"/patient/{patientId}"})
    public ResponseEntity<PatientDto> updateUser(@PathVariable("patientId") Long patientId,
                                                   @RequestBody @Valid PatientDto user){
        user.setPatientId(patientId);
        PatientDto updatedUser=patientService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }


    @Operation(
            summary = "Delete an Patient Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )

    @DeleteMapping({"/patient/{patientId}"})
    public ResponseEntity<String> deleteUser(@PathVariable("patientId") Long patientId){
        patientService.deleteUser(patientId);
        return new ResponseEntity<>("Patient details deleted successfully", HttpStatus.NO_CONTENT);
    }


}
