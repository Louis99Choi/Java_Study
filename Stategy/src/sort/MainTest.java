package sort;

import java.util.Arrays;

public class MainTest {

	public static void main(String[] args) {
		Person[] people = {
				new Person(3000, "Dooly"),
				new Person(30, "Ddochi"),
				new Person(25, "Michol"),
				new Person(20000, "Douner"),
				new Person(3, "HeeDong")
		};
		
		System.out.println("\noriginal people");
		
		for(var p : people) {
			System.out.println(p);
		}
		
		
		System.out.println("\nSort by default");
		
		Arrays.sort(people, null);
		
		for(var p : people) {
			System.out.println(p);
		}
		
		
		System.out.println("\nSort by Name");
		
		Arrays.sort(people, new NameComparator());
		
		for(var p : people) {
			System.out.println(p);
		}
		
		
		System.out.println("\nSort by Age");
		
		Arrays.sort(people, new AgeComparator());
		
		for(var p : people) {
			System.out.println(p);
		}
		
	}

}
