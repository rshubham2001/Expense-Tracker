package com.shubam.Expence_Tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.shubam.Expence_Tracker.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e, WebRequest wr) {
	 ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(400);
		errorResponse.setErrorMessage("Invalid parameter type. Please provide a valid value.");
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
 
 @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException e, WebRequest wr) {
	 ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(400);
		errorResponse.setErrorMessage("Invalid JSON payload. Please provide a valid value.");
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
 
 @ExceptionHandler(UserException.class)
 public ResponseEntity<ErrorResponse> handleUserException(UserException e, WebRequest wr){
	 ErrorResponse errorResponse = new ErrorResponse();
	 errorResponse.setErrorCode(400);
	 errorResponse.setErrorMessage(e.getMessage());
	 return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
 }
}
