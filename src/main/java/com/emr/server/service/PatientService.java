package com.emr.server.service;

import java.util.List;

import com.emr.server.model.Patient;

public interface PatientService {
	 public Patient createPatient(Patient patient);
	 public Patient updatePatient(Patient patient);
	 public void deletePatient(Long id);
	 public List<Patient> getAllPatients();
	 public Patient getPatientById(Long id);
}
