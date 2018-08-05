/**
 * 
 */
package com.luv2code.springrestdemo.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springrestdemo.model.Student;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@RestController
@RequestMapping("/students")
public class StudentRestController {
	
	@GetMapping("/listall")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("Mary", "Poppins"));
		students.add(new Student("Alex", "Phillips"));
		students.add(new Student("Michael", "Bale"));
		
		return students;
	}
}
