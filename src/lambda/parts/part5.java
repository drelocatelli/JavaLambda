package lambda.parts;

import java.util.Arrays;
import java.util.stream.Collectors;

import models.Employee;

import list.EmployeeList;

public class part5 {

	public static void main(String[] args) {
				
		EmployeeList employeeList = new EmployeeList();
		
		System.out.println("Employees by department:");
		
		Arrays.stream(employeeList.employees)
			.collect(Collectors.groupingBy(Employee::getDepartment))
			.forEach((department, employeesInDepartment) -> {
				System.out.println(department);
				
				employeesInDepartment.forEach(employee -> System.out.println(employee));
				System.out.println();
				
			});
		
	}
	
}
