/**
 * 
 */
package com.luv2code.springrestdemo.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springrestdemo.exceptions.StudentNotFoundException;
import com.luv2code.springrestdemo.model.Student;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@RestController
@RequestMapping("/students")
public class StudentRestController {
	
	private List<Student> students;
	
	@GetMapping("/")
	public List<Student> getStudents(){
		return students;
	}
	
	@PostConstruct
	private void loadData() {
		students = new ArrayList<Student>();
		students.add(new Student("Mary", "Poppins"));
		students.add(new Student("Alex", "Phillips"));
		students.add(new Student("Michael", "Bale"));
	}
	
	@GetMapping("/{studentId}")
	public Student getById(@PathVariable int studentId) {
		if (studentId<1 || studentId > students.size())
			throw new StudentNotFoundException(String.format("Student id not found: [%d]", studentId));
		return students.get(studentId - 1);
	}
}
