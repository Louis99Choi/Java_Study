package kr.ac.dankook.ace.dao;

import java.util.List;

import kr.ac.dankook.ace.dto.*;

public class PersonListManager {
	private List<Person> people;

	public PersonListManager(List<Person> people) {
		this.people = people;
	}

	public List<Person> getPeople() {
		return people;
	}
	public void setPeople(List<Person> people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "PersonListManager [people=" + people + "]";
	}

}
