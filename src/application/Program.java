package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {



	public static void main(String[] args) {

		
		System.out.println("Esse projeto foi alterado pra teste");
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		
		System.out.println("How many employees will be registered?");
		
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			
			System.out.println("Emplyoee #" + i );
			
			System.out.println("Id: ");
			
			int id = sc.nextInt();
			
			while(hasId(list, id)) {
				
				System.out.print("Id already taken. Try again: ");

				id = sc.nextInt();
				
			}
			
			System.out.println("Name: ");
			
			sc.nextLine();
			
			String name = sc.nextLine();
			
			System.out.println("Salary: ");
			
			double salary = sc.nextDouble();
			
			list.add(new Employee(id, name, salary));
			
		}
		System.out.print("Enter the employee id that will have salary increase :");
		int id = sc.nextInt();
		
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if( emp == null) {
			
			System.out.println("This id does not exist!");
		}
		else {
			System.out.println("Enter the percentagem:");
			
			int percentagem = sc.nextInt();
			
			emp.salaryIncrease(percentagem);
		}
		
		System.out.println();
		System.out.println("List of employee:\n");
		
		for (Employee obj : list) {
			System.out.println(obj);
		}
		
		
		sc.close();
	}
	public static boolean hasId(List<Employee> list, int id) {
		
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null ;
	}

}