package com.gdav.training.accounts.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.ServletException;
import jakarta.validation.ValidationException;

import com.gdav.training.accounts.exception.AccountDoesNotExistException;
import com.gdav.training.accounts.exception.AccountServiceException;
import com.gdav.training.accounts.controller.exception.model.DefaultError;
import com.gdav.training.accounts.controller.exception.model.DefaultErrorList;
import com.gdav.training.accounts.util.ErrorEnum;


/**
 * @author David G
 * 
 * This class handles the exceptions thrown by the controller
 */
@ControllerAdvice
public class AccountsControllerExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountsControllerExceptionHandler.class);
    
    /**
     * Input method arguments validation handler
     * @param pe - Input exception MethodArgumentNotValidException
     * @return Response entity with the exception object
     */
	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	public ResponseEntity<DefaultErrorList> handleValidationException(MethodArgumentNotValidException pe) {
    	LOGGER.warn("In handleValidationException", pe);
		return new ResponseEntity<>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_ERROR_PARAMS, pe.getBindingResult().getFieldError().toString())), HttpStatus.BAD_REQUEST);
	}

	/**
     * Handle input numbers format and illegal arguments exceptions
     * @param pe - Input exception IllegalArgumentException
     * @return Response entity with the exception object
     */
	@ExceptionHandler(value = {IllegalArgumentException.class})
	public ResponseEntity<DefaultErrorList> handleValidationException(IllegalArgumentException pe) {
    	LOGGER.warn("In handleValidationException", pe);
		return new ResponseEntity<>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_ERROR_PARAMS, pe.getLocalizedMessage())), HttpStatus.BAD_REQUEST);
	}

	/**
     * Handle input data validation exception
     * @param pe - Input exception TypeMismatchException
     * @return Response entity with the exception object
     */
	@ExceptionHandler(value = {TypeMismatchException.class})
	public ResponseEntity<DefaultErrorList> handleValidationException(TypeMismatchException pe) {
    	LOGGER.warn("In handleValidationException", pe);
		return new ResponseEntity<>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_ERROR_PARAMS, pe.getMostSpecificCause().toString())), HttpStatus.BAD_REQUEST);
	}

	/**
     * Handle input HTTP not supported media type exception
     * @param pe - Input exception MissingServletRequestParameterException
     * @return Response entity with the exception object
     */
	@ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class})
	public ResponseEntity<DefaultErrorList> handleValidationExceptionD(HttpMediaTypeNotSupportedException pe) {
    	LOGGER.warn("In handleValidationExceptionD", pe);
		return new ResponseEntity<>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_ERROR_OTROS_PARAMS, pe.getLocalizedMessage())), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	/**
     * Handle input HTTP message conversion exception
     * @param pe - Input exception HttpMessageConversionException
     * @return Response entity with the exception object
     */
	@ExceptionHandler(value = {HttpMessageConversionException.class})
	public ResponseEntity<DefaultErrorList> handleHttpMessageConversionException(HttpMessageConversionException pe) {
    	LOGGER.warn("In handleHttpMessageConversionException", pe);
		return new ResponseEntity<>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_ERROR_JSON_PARAMS, pe.getLocalizedMessage())), HttpStatus.BAD_REQUEST);
	}
	
	/**
     * Handle ServletException
     * @param pe - Input exception ServletException
     * @return Response entity with the exception object
     */
	@ExceptionHandler(value = {ServletException.class})
	public ResponseEntity<DefaultErrorList> handleValidationException(ServletException pe) {
    	LOGGER.warn("In handleValidationException", pe);
		return new ResponseEntity<>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_ERROR_OTROS_PARAMS, pe.getLocalizedMessage())), HttpStatus.BAD_REQUEST);
	}
	

	/**
     * Handle input data ValidationException
     * @param pe exception de tipo MethodArgumentTypeMismatchException
     * @return Response entity with the exception object
     */
	@ExceptionHandler(value = {ValidationException.class})
	public ResponseEntity<DefaultErrorList> handleValidationException(ValidationException pe) {
    	LOGGER.warn("In handleValidationException", pe);
		return new ResponseEntity<>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_ERROR_PARAMS, pe.getLocalizedMessage())), HttpStatus.BAD_REQUEST);
	}
	
	


	/**
     * Handle non existing resource
	 * @param ex Exception AccountDoesNotExistException
     * @return Response entity with the exception object
     */
    @ExceptionHandler(AccountDoesNotExistException.class)
    public ResponseEntity<DefaultErrorList> handleAccountDoesNotExistException(AccountDoesNotExistException ex) {
    	LOGGER.warn("Entity does not exist {}", ex.getMessage());
		return new ResponseEntity<>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_INEXISTENTE)), HttpStatus.NOT_FOUND);
    }

    /**
     * Handle service exception
	 * @param ex Exception AccountServiceException
     * @return Response entity with the exception object
     */
    @ExceptionHandler(AccountServiceException.class)
    public ResponseEntity<DefaultErrorList> handleAccountServiceException(AccountServiceException ex) {
    	LOGGER.error("In handleAccountServiceException", ex);
		return new ResponseEntity<>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_OPER_NO_EXITOSA)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
	/**
     * Handle generic exception
	 * @param ex Generic exception 
     * @return Response entity with the exception object
	 */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultErrorList> handleGenericException(Exception ex) {
		LOGGER.error("In handleGenericException: {}", ex);
		return new ResponseEntity<>(new DefaultErrorList(new DefaultError(ErrorEnum.EXC_GENERICO)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

	
}