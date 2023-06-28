package com.emr.server.service;

import java.util.List;

import com.emr.server.dto.PatientDTO;
import com.emr.server.model.Patient;

public interface PatientService {
	 public Patient createPatient(PatientDTO patientDto);
	 public Patient updatePatient(PatientDTO patientDto);
	 public void deletePatient(Long id);
	 public List<Patient> getAllPatients();
	 public Patient getPatientById(Long id);
}
