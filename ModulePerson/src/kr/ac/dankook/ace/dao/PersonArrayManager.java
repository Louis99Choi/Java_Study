package kr.ac.dankook.ace.dao;
import java.util.Arrays;

import kr.ac.dankook.ace.dto.*;

public class PersonArrayManager {
	private Person[] people;

	public PersonArrayManager(Person[] people) {
		super();
		this.people = people;
	}

	public Person[] getPeople() {
		return people;
	}

	public void setPeople(Person[] people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "PersonArrayManager [people=" + Arrays.toString(people) + "]";
	}
	
	
	

}
