package com.gdav.training.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;



/**
 * @author David G
 * 
 * Initial application class of Spring Boot.
 * Here we can scan different packages to load them into the Spring context
 */
@SpringBootApplication
@ComponentScan("com.gdav.training")
public class AccountsApplication {

	/**
	 * Metodo main para inicializar la aplicacion Spring Boot
	 * @param args Argumentos opcionales de envio al programa
	 */
    public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

	
	/**
	 * Method to set RestTemplate objects will be inside Spring context
	 * @return RestTemplate bean
	 */
	@Bean
	public RestTemplate restTemplate() {
		//Inicializa un RestTemplate por default
		return new RestTemplate();
	}

	

}