package com.example.demo;

public class User {
	
	private String name;
	private String surname;
	
	public User(String new_n, String new_s) {
		name = new_n;
		surname = new_s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
