package com.healthcare.patientmodule.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthcare.patientmodule.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

	@Query(value = "SELECT p FROM Patient p where p.createDate >= :createDate and p.updateDate <= :updateDate")
	public List<Patient> getPatientDetailsByGivenDate(@Param("createDate") LocalDateTime createDate, @Param("updateDate") LocalDateTime updateDate);

}
