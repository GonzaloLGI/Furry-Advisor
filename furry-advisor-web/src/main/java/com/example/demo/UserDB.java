package com.example.demo;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserDB {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	
	private String password;
	private String nickname;
	private String email;
	private Blob prof_photo;
	//Comprobar como iban las relaciones en Spring
	@OneToMany
	private List<ReviewDB> reviews;
	
	protected UserDB(){};
	
	public UserDB(int i, String nk, String psw) {
		user_id = i;
		setNickname(nk);
		setPassword(psw);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Blob getProf_photo() {
		return prof_photo;
	}

	public void setProf_photo(Blob prof_photo) {
		this.prof_photo = prof_photo;
	}
}
