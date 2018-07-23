/**
 * 
 */
package com.company.spring.boot.controller.error;

/**
 * @author NevinChen
 *
 */
public class ErrorInfo {

    private int errorCode;
    private String errorMessage;
    
    public ErrorInfo(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    
    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }
    
    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }
    
}
