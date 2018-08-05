/**
 * 
 */
package com.luv2code.springrestdemo.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springrestdemo.exceptionresponses.StudentExceptionResponse;
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
		if (studentId<1 || studentId > students.size())
			throw new StudentNotFoundException(String.format("Student id not found: [%d]", studentId));
		return students.get(studentId - 1);
	}
	
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
