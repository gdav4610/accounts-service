package com.gdav.training.accounts.controller.exception.model;

import java.io.Serializable;
import com.gdav.training.accounts.util.ErrorEnum;

/**
 * @author David G
 * 
 * Default error bean
 */
public class DefaultError implements Serializable {

    /** Variable para serializar la clase. */
    private static final long serialVersionUID = 1L;

	/**  Human readable code */
    private String code;
    
    /** Message without unnecesary inner security information */
    private String message;

    /** Error level: info, warning, error. */
    private String level;

    /** Detailed description, with no unnecesary inner security information */
    private String description;
    
    /**  A link to the error */
    private String moreInfo;

    /**
     * Constructor with input paramss
     * 
     * @param code - Human readable code
     * @param message - Message without unnecesary inner security information
     * @param level  - Error level: info, warning, error.
     * @param description - Detailed description, with no unnecesary inner security information
     * @param moreInfo - A link to the error
     */
    public DefaultError(String code, String message, String level, 
    		String description, String moreInfo) {
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = description;
		this.moreInfo = moreInfo;
	}

    /**
     * 
     * Constructor with input object
     * 
     * @param errorEnum - The input object
     */
    public DefaultError(ErrorEnum errorEnum) {
		this.code = errorEnum.getCode();
		this.message = errorEnum.getMessage();
		this.level = errorEnum.getLevel();
		this.description = errorEnum.getDescription();
		this.moreInfo = errorEnum.getMoreInfo();
	}

    /**
     * Constructor with input object and moreInfo as param
     * 
     * @param errorEnum - The input object
     * @param moreInfo - A link to the error
     */
    public DefaultError(ErrorEnum errorEnum, String moreInfo) {
		this.code = errorEnum.getCode();
		this.message = errorEnum.getMessage();
		this.level = errorEnum.getLevel();
		this.description = errorEnum.getDescription();
		this.moreInfo = moreInfo;
	}

    /**
     * Get the code
     *
     * @return The code
     */
    public String getCode() {
        return code;
    }

    /**
     * Get the message
     *
     * @return The message
     */
    public String getMessage() {
        return message;
    }


    /**
     * Get the level
     *
     * @return The level
     */
    public String getLevel() {
        return level;
    }


    /**
     * Get the description
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get more info
     *
     * @return more info about the error
     */
    public String getMoreInfo() {
        return moreInfo;
    }


}
