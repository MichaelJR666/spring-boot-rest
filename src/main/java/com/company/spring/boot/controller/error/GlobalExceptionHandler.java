/**
 * 
 */
package com.company.spring.boot.controller.error;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.spring.boot.service.ServiceException;

/**
 * @author NevinChen
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    private Map<Integer, HttpStatus> errorCodeMapping = new HashMap<>();
    
    {
        errorCodeMapping.put(ServiceException.BAD_PARAMETER_ERROR, HttpStatus.BAD_REQUEST);
        errorCodeMapping.put(ServiceException.ENTITY_CONFLICT_ERROR, HttpStatus.CONFLICT);
        errorCodeMapping.put(ServiceException.ENTITY_NOT_FOUND_ERROR, HttpStatus.NOT_FOUND);
    }
 
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ResponseEntity<ErrorInfo> handleServiceException(ServiceException e) throws Exception {
        ErrorInfo errorInfo = new ErrorInfo(e.getErrorCode(), e.getMessage());
        return new ResponseEntity<ErrorInfo>(errorInfo, getHttpStatus(e.getErrorCode()));
    }
    
    private HttpStatus getHttpStatus(int errorCode) {
        HttpStatus status = errorCodeMapping.get(errorCode);
        if (status == null) {
            throw new IllegalArgumentException("Unable to find a mapping http status code by error code " + errorCode);
        }
        return status;
    }
    
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<ErrorInfo> handleServiceException(HttpMessageNotReadableException e) throws Exception {
        ErrorInfo errorInfo = new ErrorInfo(ServiceException.BAD_PARAMETER_ERROR, "Required request body is missing or invalid.");
        return new ResponseEntity<ErrorInfo>(errorInfo, getHttpStatus(errorInfo.getErrorCode()));
    }
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorInfo> handleGeneralException(Exception e, HttpServletRequest request) {
        logger.error(e.getMessage(), e);
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something goes wrong in the server.");
        return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
