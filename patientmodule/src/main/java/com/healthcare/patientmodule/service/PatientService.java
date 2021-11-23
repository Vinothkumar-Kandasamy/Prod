package com.healthcare.patientmodule.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.healthcare.patientmodule.model.Patient;
import com.healthcare.patientmodule.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepo;
	
	public void createPatient(Patient patient) {
		patientRepo.save(patient);
	}
	
	public List<Patient> getSepecificPatientDetails(int limit, int pageNo) {
		 Pageable paging = PageRequest.of(pageNo, limit);
	        Page<Patient> pagedResult = patientRepo.findAll(paging);

	        return pagedResult.toList();
	}
	
	public void updatePatientDetails(Patient updatedPatientDetail) {
		patientRepo.save(updatedPatientDetail);
	}
	
	public void deletePatient (int patientId) {
		patientRepo.deleteById(patientId);
	}
	
	public List<Patient> getAllPatientDetails(){
		return patientRepo.findAll();
	}
	
	public List<Patient> getPatientDetailsByGivenDate(LocalDateTime createDate, LocalDateTime updateDate){
		return patientRepo.getPatientDetailsByGivenDate(createDate, updateDate);
	}

}
