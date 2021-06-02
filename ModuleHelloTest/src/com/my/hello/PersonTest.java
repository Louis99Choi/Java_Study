package com.my.hello;

import kr.ac.dankook.ace.dto.*;

public class PersonTest {

	public static void main(String[] args) {
		Person[] pArray = {
				new Person("P", 30),
				new Person("K", 20),
				new Person("S", 10),
				new Student("STU", 15, 2000),
				new Staff("STAFF", 15, "CE")				
		};

	}

}
