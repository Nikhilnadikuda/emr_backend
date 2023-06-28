package com.emr.server.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.server.dto.MedicalRecordDTO;
import com.emr.server.model.MedicalRecord;
import com.emr.server.model.Patient;
import com.emr.server.model.Staff;
import com.emr.server.repository.MedicalRecordRepository;
import com.emr.server.repository.PatientRepository;
import com.emr.server.repository.StaffRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService{
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private StaffRepository staffRepository;
	@Override
	public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }
    @Override
    public MedicalRecord getMedicalRecordById(Long id) {
        return medicalRecordRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Medical Record not found with ID: " + id));
    }

    @Override
    public MedicalRecord createMedicalRecord(MedicalRecordDTO medicalRecordDto) {
        Patient patient = patientRepository.findById(medicalRecordDto.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));
        Staff doctor = staffRepository.findByJobTitle("Doctor");
        if (doctor == null) {
            throw new IllegalStateException("Doctor not found");
        }
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setPatientId(patient.getId());
        medicalRecord.setDoctorId(doctor.getId());
        medicalRecord.setDate(medicalRecordDto.getDate());
        medicalRecord.setDiagnosis(medicalRecordDto.getDiagnosis());
        medicalRecord.setPrescription(medicalRecordDto.getPrescription());
        medicalRecord.setNotes(medicalRecordDto.getNotes());
        medicalRecordRepository.save(medicalRecord);
        return new MedicalRecord(medicalRecord.getId(),medicalRecord.getDate(),medicalRecord.getDiagnosis(),medicalRecord.getPrescription(),medicalRecord.getNotes(),medicalRecord.getPatientId(),medicalRecord.getDoctorId());
    }

    @Override
    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
        MedicalRecord record=medicalRecordRepository.findById(medicalRecord.getId()).orElseThrow(() -> new EntityNotFoundException("Medical Record not found with ID: " + medicalRecord.getId()));
        if(record!=null) {
        	record.setId(medicalRecord.getId());
        	record.setDate(medicalRecord.getDate());
        	record.setDiagnosis(medicalRecord.getDiagnosis());
        	record.setNotes(medicalRecord.getNotes());
        	record.setPrescription(medicalRecord.getPrescription());
        	record.setDoctorId(medicalRecord.getDoctorId());
        	record.setPatientId(medicalRecord.getPatientId());
        	medicalRecordRepository.save(record);
        	return record;
        }
        else {
        	return null;
        }
    }

    @Override
    public void deleteMedicalRecord(Long id) {
        medicalRecordRepository.deleteById(id);
    }

    @Override
    public List<MedicalRecord> getRecordsByPatientId(Long patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }
}
