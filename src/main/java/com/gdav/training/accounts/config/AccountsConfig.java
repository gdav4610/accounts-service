package com.gdav.training.accounts.config;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * @author David G
 * 
 * Configurations class
 */
@Configuration
@ConfigurationProperties(prefix="accounts-service")
@Validated
public class AccountsConfig {

	@NotEmpty
	private String config;
	
	
	
	/**
	 * @return Config description
	 */
	public String getConfig() {
		return config;
	}

	/**
	 * @param config - The configuration
	 */
	public void setConfig(String config) {
		this.config = config;
	}
	

}