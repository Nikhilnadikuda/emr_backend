package com.emr.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emr.server.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
	

}
