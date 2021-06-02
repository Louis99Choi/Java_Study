package kr.ac.dankook.ace.dto;

public class Staff extends Person{

	public Staff(String name, int age, String department) {
		super(name, age);
		this.department = department;
	}

	private String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Staff [department=" + department + ", name=" + name + ", age=" + age + "]";
	}
	
	

}
