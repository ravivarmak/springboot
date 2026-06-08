package com.example.day.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //vs Controller
public class EmployeeController {

	@GetMapping("/employee")
	public String getEmployee() {
		return "Employee details";
	}
}