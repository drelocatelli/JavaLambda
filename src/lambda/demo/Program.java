package lambda.demo;

import models.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import list.EmployeeList;

public class Program {
	
	public static void main(String[] args) {
		
		EmployeeList employeeList = new EmployeeList();
		
		List<Employee> employees = Arrays.asList(employeeList.employees);
		
		// ---------------------------------------------------
		
		System.out.println("Método forEach (pelo for)");
		metodoForeach(employees);
		
		System.out.println();
		
		// ---------------------------------------------------
		
		System.out.println("Método forEach (stream)");
		metodoForeachStream(employees);
		
		System.out.println();
		
		// ---------------------------------------------------
		
		System.out.println("Método filter & map");
		System.out.println(metodoFilterMap(employees));
		
		System.out.println();
		
		// ---------------------------------------------------
		
		System.out.println("Employees earning $4000 - $6000 per month sorted by salary");
		EmployeesEarningBetweenSortedBySalary(employees);
		
		System.out.println();
		
		// ---------------------------------------------------
		
		System.out.println("Employees earning $4000 - $6000 per month sorted by salary UNIQUE");
		System.out.println(EmployeesEarningBetweenSortedBySalaryUnique(employees));
		
		System.out.println();
		
		// ---------------------------------------------------
		
		System.out.println("Unique employee first name");
		UniqueEmployeeName(employees);
		
		System.out.println();
		
		// ---------------------------------------------------
		
		System.out.println("Employee names in order by last name then first name");
		employeeNamesInOrder(employees);
		
		System.out.println();
		
		// ---------------------------------------------------
		
		System.out.println("Employees by department:");
		employeeByDepartment(employees);
		
		System.out.println();
		
		// ---------------------------------------------------
		
		System.out.println("Count of employees by department");
		coutEmployeeByDepartment(employees);
		
	}
	
	private static void coutEmployeeByDepartment(List<Employee> employees) {
		employees.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
		.forEach((department, count) -> System.out.printf("%s has %d employee(s)\n", department, count));
	}
	
	private static void employeeByDepartment(List<Employee> employees) {
		
		employees.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment))
		.forEach((department, employeesInDepartment) -> {
			System.out.println(department);
			
			employeesInDepartment.forEach(employee -> System.out.println(employee));
			System.out.println();
			
		});
		
	}

	public static void metodoForeach(List<Employee> employees) {
		
		for(Employee employee: employees) {
			System.out.printf("%s %s, salário: $%.2f\n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
		}
		
	}
	
	public static void metodoForeachStream(List<Employee> employees) {
		
		employees.stream()
			.forEach(i -> System.out.println(i));
		
	}
	
	public static List<String> metodoFilterMap(List<Employee> employees) {
		
		return employees.stream()
			.filter(f -> f.getSalary() > 1900)
			.map(f-> f.getFirstName())
			.collect(Collectors.toList());
		
	}
	
	public static void EmployeesEarningBetweenSortedBySalary(List<Employee> employees) {
		
			employees.stream()
					.filter(i -> i.getSalary() >= 4000 && i.getSalary() <= 6000)
					.sorted(Comparator.comparing(Employee::getSalary))
					.collect(Collectors.toList())
					.forEach(System.out::println);			
		
	}
	
	public static Employee EmployeesEarningBetweenSortedBySalaryUnique(List<Employee> employees) {
		
		return employees.stream()
				.filter(i -> i.getSalary() >= 4000 && i.getSalary() <= 6000)
				.findFirst()
				.get();
		
	}
	
	public static void UniqueEmployeeName(List<Employee> employees) {
		
		employees.stream()
					.map(Employee::getLastName)
					.distinct()
					.sorted()
					.forEach(System.out::println);
		
	}
	
	public static void employeeNamesInOrder(List<Employee> employees) {
		
		employees.stream()
		.sorted(Comparator.comparing(Employee::getFirstName))
		.map(Employee::getFirstName)
		.forEach(System.out::println);
		
	}


}
