package com.example.java8.data;

import java.util.ArrayList;
import java.util.List;

import com.example.java8.Employee;

public class EmployeeData {
	public List<Employee> employees = new ArrayList<>();
	public static EmployeeData getInstance() {
		EmployeeData data = new EmployeeData();
		data.employees.add(new Employee("Alice", "HR", 50000, "alice@hr.in"));
		data.employees.add(new Employee("Bob", "IT", 60000, "Bob@it.in"));
		data.employees.add(new Employee("Charlie", "Finance", 55000, "charlie@fin.in"));
		return data;
	}

}
