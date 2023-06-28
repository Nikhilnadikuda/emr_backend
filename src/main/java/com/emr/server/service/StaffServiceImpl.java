package com.emr.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.server.model.Staff;
import com.emr.server.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
    private StaffRepository staffRepository;

    

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(Staff staff) {
        Staff existingStaff = staffRepository.findById(staff.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff ID"));

        existingStaff.setName(staff.getName());
        existingStaff.setAge(staff.getAge());
        existingStaff.setGender(staff.getGender());
        existingStaff.setAddress(staff.getAddress());
        existingStaff.setPhone(staff.getPhone());
        existingStaff.setJobTitle(staff.getJobTitle());
        existingStaff.setEmail(staff.getEmail());
        existingStaff.setSalary(staff.getSalary());
        existingStaff.setBenefits(staff.getBenefits());

        return staffRepository.save(existingStaff);
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

	@Override
	public Staff getStaffById(Long id) {
		return staffRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Doctor not exist with id :"+id));
	}

	@Override
	public Staff getDoctorById(Long id) {
		Staff doctor= staffRepository.findByJobTitle("Doctor");
		if(doctor!=null) {
			if(doctor.getId()==id) {
				return doctor;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
		
	}
}
