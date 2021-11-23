package com.healthcare.patientmodule.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	    
	    @ExceptionHandler(value = { InvalidInputException.class })
	    public ResponseEntity<Object> handleInvalidInputException(InvalidInputException ex) {
	    	logger.error("Invalid Input Exception: ",ex.getMessage());
	        return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	    }
}
