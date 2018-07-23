/**
 * 
 */
package com.company.spring.boot.service;

/**
 * @author NevinChen
 *
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public static final int ENTITY_CONFLICT_ERROR = 1001;
	public static final int BAD_PARAMETER_ERROR = 1002;
	public static final int ENTITY_NOT_FOUND_ERROR = 1003;
	
	private int errorCode;
	
	public ServiceException(int errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
	}
	
	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

}
