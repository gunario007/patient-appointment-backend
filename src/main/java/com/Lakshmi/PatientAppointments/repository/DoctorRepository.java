package com.Lakshmi.PatientAppointments.repository;

import com.Lakshmi.PatientAppointments.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
