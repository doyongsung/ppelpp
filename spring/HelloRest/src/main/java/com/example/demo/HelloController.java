package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// �ش� class�� REST API ó���ϴ� Controller
@RestController

// RequestMapping URI �� �������ִ� Annotation
@RequestMapping("/api")
public class HelloController {
	
// http://localhost:8001/api/hello
@GetMapping("/hello")
public String hello() {
	return "hi there~";
}
}
