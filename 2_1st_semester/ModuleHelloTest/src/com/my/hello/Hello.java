package com.my.hello;

public class Hello {
	String toWhom = "World";

	public Hello(String toWhom) {
		super();
		this.toWhom = toWhom;
	}
	
	public void sayHello() {
		System.out.println("Hello " + toWhom);
	}

}
