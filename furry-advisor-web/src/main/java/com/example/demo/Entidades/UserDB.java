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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	
	@OneToMany(mappedBy = "userRef", cascade=CascadeType.REMOVE, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<ReviewDB> reviews;
	
	/*@OneToMany(mappedBy="userRef", cascade=CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<CommentDB> comments;*/

	@Lob
	@JsonIgnore
	private Blob profPhoto;
	
	public UserDB(){};
	
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
	
	public List<ReviewDB> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDB> reviews) {
		this.reviews = reviews;
	}

	/*public List<CommentDB> getComments() {
		return comments;
	}

	public void setComments(List<CommentDB> comments) {
		this.comments = comments;
	}*/
}
