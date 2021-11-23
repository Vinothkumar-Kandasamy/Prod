package com.healthcare.patientmodule.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("patient")
public class VaultConfig {
	private String username;
    private String password;
}
