package com.healthcare.patientmodule.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@Entity
@Table(name = "Patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int patientId;

	@Column
	String patientName;

	@Column
	String nameOfDisease;
	
	@Column
	LocalDateTime admittedDate;
	
	@Column
	LocalDateTime dischargedDate;

	@LastModifiedDate
	@Column
	LocalDateTime createDate;

	@LastModifiedBy
	@Column
	String createUser;

	@LastModifiedDate
	@Column
	LocalDateTime updateDate;

	@LastModifiedBy
	@Column
	String updateUser;

}
