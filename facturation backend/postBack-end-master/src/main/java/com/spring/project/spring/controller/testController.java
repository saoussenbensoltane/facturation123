package com.spring.project.spring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;



@RestController
public class testController {
	
	//@RequestMapping(method = RequestMethod.GET,value="/test")
	@GetMapping(value="/test/{firstname}")
	
	public String getMessage(@PathVariable("firstname") String firstname)
	{
		return"hello world!!!!!"+firstname;
	}
	
}
