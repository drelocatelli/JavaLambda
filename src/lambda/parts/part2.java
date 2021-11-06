package lambda.parts;

import java.util.Arrays;
import java.util.Comparator;

import models.Employee;
import list.EmployeeList;

public class part2 {

	public static void main(String[] args) {
		
		EmployeeList employeeList = new EmployeeList();
		
		System.out.println("Employees earning $4000 - $6000 per month sorted by salary");
		Arrays.stream(employeeList.employees)
			.filter(e -> e.getSalary() >= 4000 && e.getSalary() <= 6000)
			.sorted(Comparator.comparing(Employee::getSalary))
			.forEach(System.out::println);
		
		System.out.println("\nEmployees earning $4000 - $6000 per month sorted by salary UNIQUE");
		System.out.println(Arrays.stream(employeeList.employees)
			.filter(e -> e.getSalary() >= 4000 && e.getSalary() <= 6000)
			.findFirst()
			.get()
			);
		
	}
	
}
