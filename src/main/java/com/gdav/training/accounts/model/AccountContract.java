package com.gdav.training.accounts.model;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author David G
 * 
 * Clase para el modelado del objeto de negocio a tratar por el servicio
 */
public class AccountContract implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	@NotNull
	@JsonProperty("name")
	private String name;
	

	public AccountContract(){
	}
	
	/**
	 * Constructor with values
	 * @param id - Entity id
	 * @param name - Entity name
	 */
	public AccountContract(String id, String name){
		this.id = id;
		this.name = name;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}