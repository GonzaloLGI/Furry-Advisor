package com.example.demo.Entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Clase de la entidad Comment en la BD
@Entity
public class CommentDB {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int comm_id;
	
	private String text;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;
	
	private int usefullness;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	private UserDB userRef;
	
	@ManyToOne
	private ReviewDB reviewRef;
	
	public CommentDB() {};
	
	public CommentDB(Date d, String txt, int usf,  UserDB us, ReviewDB rv) {
		setDate(d);
		setUser_or(us);
		reviewRef = rv;
		usefullness = usf;
		text = txt;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getUsefness() {
		return usefullness;
	}

	public void setUsefness(int usefness) {
		this.usefullness = usefness;
	}

	public ReviewDB getReview_or() {
		return reviewRef;
	}

	public void setReview_or(ReviewDB review_or) {
		this.reviewRef = review_or;
	}

	public UserDB getUser_or() {
		return userRef;
	}

	public void setUser_or(UserDB user_or) {
		this.userRef = user_or;
	}
}
