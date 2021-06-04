package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String welcome() {
		return "Hello";
	}

	@GetMapping("/test")
	public int test() {
		return 10/0; 
	}

	@GetMapping("/mdc")
	public String mdcTest() {
		// You can put values in the MDC at any time. Before anything else
		// we put the first name
		MDC.put("first", "Dorothy");

		Logger logger = LoggerFactory.getLogger(HelloController.class);
		// We now put the last name
		MDC.put("last", "Parker");

		// The most beautiful two words in the English language according
		// to Dorothy Parker:
		logger.info("Check enclosed.");
		logger.debug("The most beautiful two words in English.");

		MDC.put("first", "Richard");
		MDC.put("last", "Nixon");
		logger.info("A default test message");
		logger.info("Some random message");
		
		return "Done";
	}

}
