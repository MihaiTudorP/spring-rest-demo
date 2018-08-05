/**
 * 
 */
package com.luv2code.springrestdemo.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@RestController
@RequestMapping("/test")
public class DemoRestController {
	// add code for the "/hello" endpoint
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello world!";
	}
}
