package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
	
	
	@GetMapping(path = "/hello") //http://localhost:8001/api/get/hello
	public String hello() {
	    return "get Hello";
	}
	
	
	@RequestMapping(path = "/hi",method = RequestMethod.GET)  // get  http://localhost:8001/api/get/hi
	public String hi() {
		return "hi";
		
	}
	
	public String pathVaria

}
