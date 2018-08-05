/**
 * 
 */
package com.luv2code.springrestdemo.exceptionresponses;

import lombok.Data;

/**
 * @author Mihai-Tudor Popescu
 *
 */
public @Data class StudentExceptionResponse {
	private int status;
	private String message;
	private long timeStamp;
}
