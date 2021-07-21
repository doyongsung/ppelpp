package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// 해당 class는 REST API 처리하는 Controller
@RestController

// RequestMapping URI 를 지정해주는 Annotation
@RequestMapping("/api")
public class HelloController {
	
// http://localhost:8001/api/hello
@GetMapping("/hello")
public String hello() {
	return "hi there~";
}
}
