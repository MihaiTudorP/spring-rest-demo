/**
 * 
 */
package com.luv2code.springrestdemo.exceptions;

/**
 * @author Mihai-Tudor Popescu
 *
 */
public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3892617915492907739L;

	public StudentNotFoundException(String message) {
		super(message);
	}

}
