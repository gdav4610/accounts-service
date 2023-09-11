package com.gdav.training.accounts.util;


/**
 * @author David G
 *  
 * Error messages enum class used for HTTP responses
 * 
 */
public enum ErrorEnum {

	EXC_GENERICO("EXC.000", "Generic error", "Generic internal server error", AccountsConstants.ERROR, ""),

	EXC_ERROR_PARAMS("EXC.001", "Invalid parameters", "Invalid input parameters", AccountsConstants.WARNING, ""),

	EXC_ERROR_OTROS_PARAMS("EXC.002", "Invalid parameters", "Invalid parameters or headers", AccountsConstants.WARNING, ""),

	EXC_ERROR_JSON_PARAMS("EXC.003", "Invalid input JSON", "Needs a valid input JSON", AccountsConstants.WARNING, ""),
	
	EXC_DUPLICADO("EXC.100", "Duplicated Account", "Account already exists", AccountsConstants.WARNING, ""),
	
	EXC_INEXISTENTE("EXC.101", "Account does not exist", "Account does not exist, please validate", AccountsConstants.WARNING, ""),
	
	EXC_OPER_NO_EXITOSA("EXC.102", "Unsuccessful operation", "Unsuccessful operation", AccountsConstants.ERROR, ""),

	EXC_OPER_CON_ERRORES("EXC.103", "Operation with errors", "Operation with errors", AccountsConstants.ERROR, ""),

	EXC_INEXISTENTES("EXC.104", "Accounts not found", "No records found, please validate", AccountsConstants.WARNING, "");
	
    private final String code;
    
    private final String message;

	private final String description;

    private final String level;

    private final String moreInfo;

    
    ErrorEnum(final String code, final String message, 
    		final String description, final String level, final String moreInfo ) {
        this.code = code;
        this.message = message;
        this.description = description;
        this.level = level;
        this.moreInfo = moreInfo;
    }


	public String getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}


	public String getDescription() {
		return description;
	}


	public String getLevel() {
		return level;
	}


	public String getMoreInfo() {
		return moreInfo;
	}



}
