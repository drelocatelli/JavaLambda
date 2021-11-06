package lambda.parts;

import java.util.Arrays;
import java.util.Comparator;

import list.EmployeeList;
import models.Employee;

public class part4 {

	public static void main(String[] args) {
		
		EmployeeList employeeList = new EmployeeList();
		
		System.out.println("Employee names in order by last name then first name:");
		Arrays.stream(employeeList.employees)
			.sorted(Comparator.comparing(Employee::getFirstName))
			.map(Employee::getFirstName)
			.forEach(System.out::println);
		
	}
	
}
