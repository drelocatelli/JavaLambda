package lambda;

import java.util.Arrays;

import models.Employee;

import list.EmployeeList;

public class part7 {

	public static void main(String[] args) {
		
		EmployeeList employeeList = new EmployeeList();
		
		System.out.println("Sum of employees salaries (via sum method):");
		System.out.println(Arrays.stream(employeeList.employees)
			.mapToDouble(Employee::getSalary)
			.sum()
			);
		
		System.out.println("Sum of employees salaries (via reduce method):");
		System.out.println(Arrays.stream(employeeList.employees)
					.mapToDouble(Employee::getSalary)
					.reduce(0, (value1, value2) -> value1 + value2)
				);
		
		System.out.println("Average of employees salaries:");
		System.out.printf("%.2f", Arrays.stream(employeeList.employees)
					.mapToDouble(Employee::getSalary)
					.average()
					.getAsDouble()
				);
		
		
		
	}
	
}
