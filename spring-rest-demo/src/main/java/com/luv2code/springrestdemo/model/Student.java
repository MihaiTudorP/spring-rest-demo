/**
 * 
 */
package com.luv2code.springrestdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@NoArgsConstructor
public @Data class Student {
	private String firstName;
	private String lastName;
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}