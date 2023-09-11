package com.gdav.training.accounts.controller.exception.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author David G
 * 
 * Default error list for exception handling 
 */
public class DefaultErrorList implements Serializable {

	/** Variable para serializar la clase. */
	private static final long serialVersionUID = 1L;

	/** The errors list */
	private List<DefaultError> errors;
	
	/** 
	 * Constructor
	 * @param errorBean Error bean
	 */
	public DefaultErrorList(final DefaultError errorBean){
		this.add(errorBean);
	}

	/**
	 * Get Errors list
	 *
	 * @return the errors list
	 */
	public List<DefaultError> getErrors() {
		return new ArrayList<>(errors);
	}

	/**
	 * Set Errors list
	 *
	 * @param errors The new list to set
	 */
	public void setErrors(List<DefaultError> errors) {
		this.errors = new ArrayList<>(errors);
	}

	/**
	 * Adds the error bean to the list.
	 *
	 * @param errorBean - The error bean to add
	 */
	public void add(final DefaultError errorBean) {
		if (this.errors == null || this.errors.isEmpty()) {
			this.errors = new ArrayList<>();
		}
		this.errors.add(errorBean);
	}
	
	/**
	 * @return To JSON string
	 * @throws JsonProcessingException - When there is a parsing exception
	 */
	public String toJsonString() throws JsonProcessingException{
		ObjectMapper objectMapper= new ObjectMapper();
		return objectMapper.writeValueAsString(this);
	}
}
