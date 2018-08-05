/**
 * 
 */
package com.luv2code.springrestdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.luv2code.springrestdemo")
public class DemoAppConfig {

}
