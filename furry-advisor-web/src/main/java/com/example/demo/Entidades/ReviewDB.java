package com.example.demo.Entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Clase de la entidad Review en la BD
@Entity
public class ReviewDB {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rev_id;
	
	@Column(nullable=false)
	private int rating;
	
	private String reviewText;
	
	@Column(nullable=false)
	private Date date_rev;
	
	@Column(nullable=false)
	private int overallUsefness;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	private UserDB userRef;
	
	@ManyToOne
	private PlaceDB placRef;
	
	public ReviewDB() {};
	
	public ReviewDB(int rt, String txt, Date dt, int usf, UserDB us, PlaceDB pl) {
		rating = rt;
		reviewText = txt;
		date_rev = dt;
		overallUsefness = usf;
		userRef = us;
		placRef = pl;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getText() {
		return reviewText;
	}
	
	public void setText(String text) {
		this.reviewText = text;
	}
	
	public Date getDate() {
		return date_rev;
	}
	
	public void setDate(Date date) {
		this.date_rev = date;
	}
	
	public int getO_usefness() {
		return overallUsefness;
	}
	
	public void setO_usefness(int o_usefness) {
		this.overallUsefness = o_usefness;
	}
	
	public UserDB getUserOwn() {
		return userRef;
	}

	public void setUserOwn(UserDB user) {
		this.userRef = user;
	}
	
	public PlaceDB getPlaceOwn() {
		return placRef;
	}

	public void setPlaceOwn(PlaceDB place) {
		this.placRef = place;
	}
}
