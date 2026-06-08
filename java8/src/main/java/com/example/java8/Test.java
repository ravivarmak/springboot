package com.example.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.java8.data.EmployeeData;

public class Test {

	public static void main(String[] args) {
		
		EmployeeData data = EmployeeData.getInstance();
		for(Employee emp : data.employees) {
			System.out.println(emp);
		}
		findDuplicates();
		findUniqueElements();
		findDuplicates2();
		findDuplicate3();
		wordCount();
		findSecondLargest();
		findEmpwithHighestSal(data.employees);
	}
	private static void findDuplicates() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,2,3,6,7,1);
		numbers.stream().filter(n-> numbers.indexOf(n) != numbers.lastIndexOf(n)).distinct().forEach(System.out::println);
	}
	private static void findUniqueElements() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,2,3,6,7,1);
		numbers.stream().filter(n->numbers.indexOf(n)==numbers.lastIndexOf(n)).distinct().forEach(System.out::println);
	}
	private static void findDuplicates2() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,2,3,6,7,1);
		Set<Integer> duplicates = numbers.stream().filter(n->Collections.frequency(numbers, n)>1).collect(Collectors.toSet());
		duplicates.forEach(d->System.out.print(d));
	}
	private static void findDuplicate3() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,2,3,6,7,1);
		Set<Integer> seen = new HashSet<>();
		Set<Integer> res =numbers.stream().filter(n->!seen.add(n)).collect(Collectors.toSet());
		System.out.println();
		res.forEach(a->System.out.print(a));
		System.out.println();
		seen.forEach(a->System.out.print(a));
		
		
	}
	private static void wordCount() {
		String text = "java is good java is powerful java";
		Map<String,Long> textMap= Arrays.stream(text.split("\\s+")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(textMap);
		
	}
	private static void findSecondLargest() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,2,3,6,7,1);
		int res = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
		System.out.println(res);
	}
	private static void findEmpwithHighestSal(List<Employee> employees) {
		Employee employee = employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
		System.out.println(employee);
	}
	
	

}
