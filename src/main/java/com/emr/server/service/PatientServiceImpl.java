package com.emr.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.server.dto.PatientDTO;
import com.emr.server.model.Patient;
import com.emr.server.repository.PatientRepository;
@Service
public class PatientServiceImpl implements PatientService{
	@Autowired 
	private PatientRepository patientRepository;
	@Override
	public Patient createPatient(PatientDTO patientDto) {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setAge(patientDto.getAge());
        patient.setGender(patientDto.getGender());
        patient.setAddress(patientDto.getAddress());
        patient.setPhone(patientDto.getPhone());
        patient.setEmail(patientDto.getEmail());
        patient.setMedicalHistory(patientDto.getMedicalHistory());
        patient.setTreatmentPlan(patientDto.getTreatmentPlan());

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
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));
    }
	@Override
	public Patient updatePatient(PatientDTO patientDto) {
		Patient patient = patientRepository.findById(patientDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));
        patient.setName(patientDto.getName());
        patient.setAge(patientDto.getAge());
        patient.setGender(patientDto.getGender());
        patient.setAddress(patientDto.getAddress());
        patient.setPhone(patientDto.getPhone());
        patient.setEmail(patientDto.getEmail());
        patient.setMedicalHistory(patientDto.getMedicalHistory());
        patient.setTreatmentPlan(patientDto.getTreatmentPlan());

        return patientRepository.save(patient);
	}
	
	
}
