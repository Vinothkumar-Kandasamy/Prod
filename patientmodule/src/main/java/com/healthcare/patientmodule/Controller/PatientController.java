package com.healthcare.patientmodule.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.patientmodule.Exception.InvalidInputException;
import com.healthcare.patientmodule.aspect.LogTimeAnnotation;
import com.healthcare.patientmodule.model.Patient;
import com.healthcare.patientmodule.service.PatientService;

@RestController
@RequestMapping(path = "/api/patient")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@PostMapping(path = "/createPatient" , consumes = "application/json")
	@LogTimeAnnotation
	public ResponseEntity<String> createPatient(@RequestBody Patient patient) throws InvalidInputException {
		
		if(patient ==  null || Objects.isNull(patient)) {
			throw new InvalidInputException();
		}
		
		try {
			patientService.createPatient(patient);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/getSpecificPatientDetails")
	@LogTimeAnnotation
	public ResponseEntity<List<Patient>> getSepcificPatientDetails(@RequestParam(name = "limit") int limit, @RequestParam(name = "pageNo") int pageNo) throws InvalidInputException {
		
			List<Patient> patientdetails = patientService.getSepecificPatientDetails(limit,pageNo);
			if(!patientdetails.isEmpty()) {
				return new ResponseEntity<List<Patient>>(patientdetails,HttpStatus.OK);
			} else {
				throw new InvalidInputException();
			}
	}
	
	
	@GetMapping(value = "/getAllPatientDetails")
	@LogTimeAnnotation
	public ResponseEntity<List<Patient>> getAllPatientDetails() throws InvalidInputException {
		
		List<Patient> userdetailList = patientService.getAllPatientDetails();
			if(!userdetailList.isEmpty()) {
				return new ResponseEntity<List<Patient>>(userdetailList,HttpStatus.OK);
			} else {
				throw new InvalidInputException();
			}
	}
	
	@RequestMapping(path = "/updatePatientDetails")
	@LogTimeAnnotation
	public ResponseEntity<String> updatePatientDetails(@RequestBody Patient updatedPatient) throws InvalidInputException {
		
		if(updatedPatient ==  null || Objects.isNull(updatedPatient)) {
			throw new InvalidInputException();
		}
		
		try {
			patientService.updatePatientDetails(updatedPatient);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}	
	}
	
	@RequestMapping(path = "/deletePatient")
	@LogTimeAnnotation
	public ResponseEntity<String> deletePatient(@RequestParam(name = "id") int patientId) {
		
			try {
				patientService.deletePatient(patientId);
				return new ResponseEntity<String>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
	}
	
	@GetMapping(value = "/getPatientDetailsByGivenDate")
	@LogTimeAnnotation
	public ResponseEntity<List<Patient>> getPatientDetailsBetweenGivenDate(@RequestParam(name ="createDate") String createDate, @RequestParam(name ="updateDate") String updateDate) throws InvalidInputException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		LocalDateTime createDateTime = LocalDateTime.parse(createDate, formatter);
		LocalDateTime updateDateTime = LocalDateTime.parse(updateDate, formatter);
		List<Patient> userdetailList = patientService.getPatientDetailsByGivenDate(createDateTime, updateDateTime);
			if(!userdetailList.isEmpty()) {
				return new ResponseEntity<List<Patient>>(userdetailList,HttpStatus.OK);
			} else {
				throw new InvalidInputException();
			}
	}
	
}
