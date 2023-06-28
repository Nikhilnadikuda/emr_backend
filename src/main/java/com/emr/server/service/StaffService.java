package com.emr.server.service;

import java.util.List;

import com.emr.server.model.Staff;

public interface StaffService {
    List<Staff> getAllStaff();
    Staff createStaff(Staff staff);
    Staff updateStaff(Staff staff);
    void deleteStaff(Long id);
}
