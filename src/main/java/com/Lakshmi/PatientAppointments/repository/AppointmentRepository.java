package com.Lakshmi.PatientAppointments.repository;

import com.Lakshmi.PatientAppointments.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
