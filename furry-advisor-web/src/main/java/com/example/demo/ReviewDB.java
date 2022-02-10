package com.example.demo;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ReviewDB {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rev_id;
	
	private int rating;
	private String text;
	private Date date;
	private int o_usefness;
	//Comprobar como iban las relaciones escritas en Spring
	/*@OneToMany
	private UserDB user_id;
	//@ManyToOne
	private PlaceDB place_id;
	//@OneToMany
	private List<CommentDB> comments;*/
	
	public ReviewDB() {};
	
	public ReviewDB(int id, int rt, String txt, Date dt, int usf, UserDB user, PlaceDB place) {
		rev_id = id;
		rating = rt;
		text = txt;
		date = dt;
		o_usefness = usf;
		/*user_id = user;
		place_id = place;*/
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
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
	public int getO_usefness() {
		return o_usefness;
	}
	public void setO_usefness(int o_usefness) {
		this.o_usefness = o_usefness;
	}

	/*public List<CommentDB> getComments() {
		return comments;
	}

	public void setComments(List<CommentDB> comments) {
		this.comments = comments;
	}*/
}
