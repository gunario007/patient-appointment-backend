package com.Lakshmi.PatientAppointments.repository;

import com.Lakshmi.PatientAppointments.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication,Long> {



}
