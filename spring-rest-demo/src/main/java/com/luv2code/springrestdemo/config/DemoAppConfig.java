/**
 * 
 */
package com.luv2code.springrestdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.luv2code.springrestdemo.exceptionresponses.StudentExceptionResponse;
import com.luv2code.springrestdemo.exceptions.StudentNotFoundException;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.luv2code.springrestdemo")
public class DemoAppConfig {
	@ExceptionHandler
	public ResponseEntity<StudentExceptionResponse> handleException(StudentNotFoundException e){
		StudentExceptionResponse exceptionResp = new StudentExceptionResponse();
		
		exceptionResp.setStatus(HttpStatus.NOT_FOUND.value());
		exceptionResp.setMessage(e.getMessage());
		exceptionResp.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(exceptionResp, HttpStatus.NOT_FOUND);
	}
	
	//add generic exception handler
	@ExceptionHandler
	public ResponseEntity<StudentExceptionResponse> handleException(Exception e){
		StudentExceptionResponse exceptionResp = new StudentExceptionResponse();
		
		exceptionResp.setStatus(HttpStatus.BAD_REQUEST.value());
		exceptionResp.setMessage(e.getMessage());
		exceptionResp.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(exceptionResp, HttpStatus.BAD_REQUEST);
	}
}
