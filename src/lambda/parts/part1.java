package lambda.parts;

import java.util.Arrays;

import list.EmployeeList;

public class part1 {

	public static void main(String[] args) {
		
		EmployeeList employeeList = new EmployeeList();
		
		System.out.println("Complete employee list:");
		Arrays.stream(employeeList.employees)
			.forEach(i -> {
				System.out.println(i);
			});
		
		
	}
	
}
