package com.my.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import kr.ac.dankook.ace.dao.PersonArrayManager;
import kr.ac.dankook.ace.dao.PersonListManager;
import kr.ac.dankook.ace.dto.Person;
import kr.ac.dankook.ace.dto.Staff;
import kr.ac.dankook.ace.dto.Student;

public class MainTest {
	public static void main(String[] args) {
		Person[] pArray = {
				new Person("P", 30),
				new Person("K", 20),
				new Person("S", 10),
				new Student("STU", 15, 2000),
				new Staff("ACE", 15, "CE")				
		};
		
		for(Person p: pArray) {
			System.out.println(p);
		}
		
		System.out.println("\nPersonArrayManager");
		PersonArrayManager aManager = new PersonArrayManager(pArray);
		System.out.println(aManager);
		
		System.out.println("\npList");
		List<Person> pList = new ArrayList<>(Arrays.asList(pArray));
		for(Person p: pList) {
			System.out.println(p);
		}
		
		System.out.println("\nPersonListManager");
		PersonListManager pListManager = new PersonListManager(pList);
		System.out.println(pListManager);
		
		System.out.println("\nPerson Array Sort by default (Comparable)");
		Arrays.sort(pArray);
		System.out.println("\nAfter Sort pArray (Comparable)");
		for (Person p : pArray) {
			System.out.println(p);
		}
		
		System.out.println("\nPerson Array Sort by age Comparator (anonymous class)");
		Arrays.sort(pArray, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getAge() - p2.getAge();
			}
		});
		System.out.println("\nAfter Sort pArray (anonymous class)");
		for (Person p : pArray) {
			System.out.println(p);
		}
		
		System.out.println("\nPerson Array Sort by name Comparator (lamda)");
		Arrays.sort(pArray, (p1, p2) -> p1.getName().compareTo(p2.getName()));
		System.out.println("\nAfter Sort pArray (lamda)");
		for (Person p : pArray) {
			System.out.println(p);
		}
		
		//p.List start===========================
		System.out.println("\nSort pList by default (Comparable)");
		pList.sort(null);
		System.out.println("\nAfter Sort pList (Comparable)");
		for (Person p : pList) {
			System.out.println(p);
		}
		
		System.out.println("\nPerson Sort pList by age Comparator (anonymous class)");
		pList.sort(new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getAge() - p2.getAge();
			}
		});
		System.out.println("\nSort pList (anonymous class)");
		for (Person p : pList) {
			System.out.println(p);
		}
		
		System.out.println("\nSort pList by name Comparator (lamda)");
		pList.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
		System.out.println("\nAfter Sort pList (lamda)");
		for (Person p : pList) {
			System.out.println(p);
		}
		
		// HashMap
		System.out.println("\n\nHashMap");
		Map<Integer, Person> pMap = new HashMap<>();
		
		//HashMap_array
		System.out.println("HashMap_array");
		for(int i = 0; i < pArray.length; i++) {
			pMap.put(i, pArray[i]);
		}
		for(Map.Entry<Integer, Person> entry: pMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		//HashMap_List
		System.out.println("HashMap_list");
		for(int i = 0; i < pList.size(); i++) {
			pMap.put(i, pList.get(i));
		}		
		for(Map.Entry<Integer, Person> entry: pMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// HashMap2_Order
		System.out.println("\n\nHashMap2_Order");
		Map<Order, Person> pMap2 = new HashMap<>();

		for (Order o : Order.values()) {
			pMap2.put(o, pArray[o.ordinal()]);
		}
		for (Map.Entry<Order, Person> entry : pMap2.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		
		// Sorted_HashMap3
		System.out.println("\n\nSorted_HashMap3");
		List<Map.Entry<Order, Person>> entries = new ArrayList<>(pMap2.entrySet());
		entries.sort(new Comparator<Map.Entry<Order, Person>>(){ // Sorting by Person Name
			@Override
			public int compare(Map.Entry<Order, Person> o1, Map.Entry<Order, Person> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		Map<Order, Person> pMap3 = new LinkedHashMap<>();

		for (Map.Entry<Order, Person> entry : entries) {
			pMap3.put(entry.getKey(), entry.getValue());
		}
		for (Map.Entry<Order, Person> entry : pMap3.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}
	

}
