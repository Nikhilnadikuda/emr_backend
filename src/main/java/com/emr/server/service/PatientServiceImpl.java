package com.emr.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.server.model.Patient;
import com.emr.server.repository.PatientRepository;
@Service
public class PatientServiceImpl implements PatientService{
	@Autowired 
	private PatientRepository patientRepository;
	@Override
	public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
	@Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
	@Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
	@Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElse(null);
    }
	@Override
	public Patient updatePatient(Patient patient) {
		Patient updatedPatient = patientRepository.findById(patient.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));
		updatedPatient.setName(patient.getName());
		updatedPatient.setAge(patient.getAge());
		updatedPatient.setGender(patient.getGender());
		updatedPatient.setAddress(patient.getAddress());
		updatedPatient.setPhone(patient.getPhone());
		updatedPatient.setEmail(patient.getEmail());
		updatedPatient.setMedicalHistory(patient.getMedicalHistory());
		updatedPatient.setTreatmentPlan(patient.getTreatmentPlan());

        return patientRepository.save(updatedPatient);
	}
}
