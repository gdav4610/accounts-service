package com.gdav.training.accounts.model;

import java.io.Serializable;


import jakarta.validation.constraints.NotNull;

/**
 * @author David G
 * 
 * Java bean class for Account
 */
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotNull
	private String name;
	

	public Account(){
	}

	/**
	 * Constructor with object
	 * @param account - Entity object
	 */
	public Account(Account account){
		this.id = account.getId();
		this.name = account.getName();
	}
	
	/**
	 * Constructor with values
	 * @param id - entity id
	 * @param name - entity name
	 */
	public Account(Long id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + "]";
	}

}