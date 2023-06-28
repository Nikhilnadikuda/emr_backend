package com.emr.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emr.server.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByJobTitle(String jobTitle);
}