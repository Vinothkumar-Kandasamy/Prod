package com.healthcare.patientmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.healthcare.patientmodule.config.VaultConfig;

@SpringBootApplication
@EnableConfigurationProperties(VaultConfig.class)
public class PatientModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientModuleApplication.class, args);
	}

}
