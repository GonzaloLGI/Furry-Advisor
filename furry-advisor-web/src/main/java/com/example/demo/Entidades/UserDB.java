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

import com.fasterxml.jackson.annotation.JsonIgnore;

//Clase de la entidad User en la BD
@Entity
public class UserDB {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false,unique=true)
	private String nickname;
	
	private String email;
	
	@OneToMany(cascade=CascadeType.REMOVE)
	private List<ReviewDB> reviews;
	
	@OneToMany(cascade=CascadeType.REMOVE)
	private List<CommentDB> comments;
	
	@Lob
	@JsonIgnore
	private Blob profPhoto;
	
	protected UserDB(){};
	
	public UserDB(String nk, String psw, String em, Blob photo) {
		setNickname(nk);
		setPassword(psw);
		email = em;
		profPhoto = photo;
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
		return profPhoto;
	}

	public void setProf_photo(Blob prof_photo) {
		this.profPhoto = prof_photo;
	}
}
