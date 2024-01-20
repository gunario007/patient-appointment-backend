package com.Lakshmi.PatientAppointments.controllers;

import com.Lakshmi.PatientAppointments.dto.AppointmentDto;
import com.Lakshmi.PatientAppointments.dto.PatientDto;
import com.Lakshmi.PatientAppointments.service.AppointmentService;
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
        name = "CRUD API's for Appointment Resource"

)
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AppointmentController {

    private AppointmentService appointmentService;


    @Operation(
            summary = "Create Appointment Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )


    @PostMapping("/appointment/create")
    public ResponseEntity<AppointmentDto> addAppointment(@RequestBody @Valid AppointmentDto appointmentDto){
        AppointmentDto createAppointment= appointmentService.addAppointment(appointmentDto);
        return new ResponseEntity<>(createAppointment, HttpStatus.CREATED);

    }

    @Operation(
            summary = "Get Appointment Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )

    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<AppointmentDto> viewAppointmentById(@PathVariable("appointmentId") Long appointmentId){
        AppointmentDto appointment=appointmentService.viewAppointmentById(appointmentId);
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }


    @Operation(
            summary = "Get All Appointment Resources"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 OK"
    )

    @GetMapping("//appointments")
    public ResponseEntity<List<AppointmentDto>> viewAppointment(){
        List<AppointmentDto> appointments=appointmentService.viewAllAppointments();
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }


    @Operation(
            summary = "Update an Appointment Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )

    @PutMapping("/appointment/{appointmentId}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable("appointmentId") Long appointmentId,
                                                 @RequestBody @Valid AppointmentDto appointment){
        appointment.setAppointmentId(appointmentId);
        AppointmentDto updatedAppointment=appointmentService.updateAppointment(appointment);
        return new ResponseEntity<>(updatedAppointment,HttpStatus.OK);

    }


    @Operation(
            summary = "Delete an Appointment Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )

    @DeleteMapping("/appointment/{appointmentId}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("appointmentId") Long appointmentId){
        appointmentService.deleteAppointment(appointmentId);
        return new ResponseEntity<>("Appointment details deleted successfully", HttpStatus.NO_CONTENT);
    }

}
