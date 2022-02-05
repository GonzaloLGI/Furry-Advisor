package com.example.demo;

public class User {
	
	private String name;
	private String surname;
	private String password;
	
	public User(String new_n, String new_s, String new_p) {
		name = new_n;
		surname = new_s;
		setPassword(new_p);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
