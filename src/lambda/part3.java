package lambda;

import java.util.Arrays;

import list.EmployeeList;
import models.Employee;

public class part3 {

	public static void main(String[] args) {
		
		EmployeeList employeeList = new EmployeeList();
		
		System.out.println("Unique employee last name:");
		Arrays.stream(employeeList.employees)
			.map(Employee::getLastName)
			.distinct()
			.sorted()
			.forEach(System.out::println);
	}
	
}
