package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.payload.ApiResponse;
/**
 * Global exception handler for handling exceptions thrown by controllers.
 * <p>
 * This class is annotated with {@code @RestControllerAdvice}, indicating that it provides centralized
 * exception handling for all controllers in the application.
 */
@RestControllerAdvice
public class GlobleExceptionHandler {
    /**
     * Exception handler for ResourceNotFoundException.
     * <p>
     * This method handles ResourceNotFoundException and returns an appropriate API response
     * with a message, status, and HTTP status code indicating "NOT_FOUND".
     *
     * @param ex The ResourceNotFoundException instance.
     * @return ResponseEntity containing an API response with a message, status, and HTTP status code.
     */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFound(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, true, HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
}


