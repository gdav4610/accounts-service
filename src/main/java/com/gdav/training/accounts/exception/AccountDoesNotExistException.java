package com.gdav.training.accounts.exception;

import com.gdav.training.accounts.util.ErrorEnum;

/**
 * @author David G
 * 
 * Exception class for non existing Account 
 */
public class AccountDoesNotExistException extends Exception {

    private static final long serialVersionUID = 1303454450535514738L;
    


    /**
     * Constructor
     * @param message Mensaje de error
     */
    public AccountDoesNotExistException(String message) {
        super(message);
    }
    

    /**
     * Constructor
     * @param message Mensaje de error
     * @param causa Causa completa del error
     */
    public AccountDoesNotExistException(String message, Throwable causa) {
        super(message, causa);
    }
    


    /**
     * Constructor que la interfaz del enumerador de error
     * @param errorEnum Interfaz de enumerador de error
     */
    public AccountDoesNotExistException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
    }
    
    
    /**
     * Constructor que la interfaz del enumerador de error
     * @param errorEnum Interfaz de enumerador de error
     * @param causa Causa completa del error
     */
    public AccountDoesNotExistException(ErrorEnum errorEnum, Throwable causa) {
        super(errorEnum.getMessage(), causa);
    }
    
}