package com.example.demo.Entidades;

import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserDB {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String nickname;
	private String email;
	@Lob
	@JsonIgnore
	private Blob prof_photo;
	
	protected UserDB(){};
	
	public UserDB(int i, String nk, String psw, String em, Blob photo) {
		user_id = i;
		setNickname(nk);
		setPassword(psw);
		email = em;
		prof_photo = photo;
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
