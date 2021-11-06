package lambda;

import java.util.Arrays;
import java.util.stream.Collectors;

import list.EmployeeList;
import models.Employee;

public class part6 {

	public static void main(String[] args) {
		
		EmployeeList employeeList = new EmployeeList();
		
		System.out.println("Count of employees by department");
		Arrays.stream(employeeList.employees)
			.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
			.forEach((department, count) -> System.out.printf("%s has %d employee(s)\n", department, count));
		
	}
	
}
