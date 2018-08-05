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

import com.luv2code.springrestdemo.model.Student;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@RestController
@RequestMapping("/students")
public class StudentRestController {
	
	private List<Student> students;
	
	@GetMapping("/list-all")
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
	
	@GetMapping("/get-by-id/{studentId}")
	public Student getById(@PathVariable int studentId) {
		if (studentId<1 || studentId > students.size()) return null;
		return students.get(studentId - 1);
	}
}
