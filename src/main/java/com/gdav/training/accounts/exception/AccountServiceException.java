package com.gdav.training.accounts.exception;

import com.gdav.training.accounts.util.ErrorEnum;

/**
 * @author David G
 * 
 * Business logic AccountServiceException
 */
public class AccountServiceException extends Exception {

    private static final long serialVersionUID = 1303454450535514738L;
    


    /**
     * Constructor
     * @param message Mensaje de error
     */
    public AccountServiceException(String message) {
        super(message);
    }
    

    /**
     * Constructor
     * @param message - Error message
     * @param causa The exception cause
     */
    public AccountServiceException(String message, Throwable causa) {
        super(message, causa);
    }
    


    /**
     * Constructor with enum
     * @param errorEnum Interface of error enum
     */
    public AccountServiceException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
    }
    
    
    /**
     * Constructor with enum
     * @param errorEnum The errorEnum interface
     * @param causa Complete exception cause
     */
    public AccountServiceException(ErrorEnum errorEnum, Throwable causa) {
        super(errorEnum.getMessage(), causa);
    }
    
}