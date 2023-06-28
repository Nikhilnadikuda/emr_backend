package com.emr.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emr.server.model.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
	List<MedicalRecord> findByPatientId(Long patientId);
}	
