package com.Lakshmi.PatientAppointments.repository;

import com.Lakshmi.PatientAppointments.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
