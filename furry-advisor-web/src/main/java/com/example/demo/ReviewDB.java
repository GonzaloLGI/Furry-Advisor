package com.example.demo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ReviewDB {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rev_id;
	
	private int rating;
	private String text;
	
	private Date date_r;
	private int o_usefness;
	//Comprobar como iban las relaciones escritas en Spring
	@OneToMany(cascade=CascadeType.ALL)
	private List<CommentDB> comments;
	
	public ReviewDB() {};
	
	public ReviewDB(int id, int rt, String txt, Date dt, int usf, List<CommentDB> comms) {
		rev_id = id;
		rating = rt;
		text = txt;
		date_r = dt;
		o_usefness = usf;
		comments = comms;
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
		return date_r;
	}
	public void setDate(Date date) {
		this.date_r = date;
	}
	public int getO_usefness() {
		return o_usefness;
	}
	public void setO_usefness(int o_usefness) {
		this.o_usefness = o_usefness;
	}

	public List<CommentDB> getComments() {
		return comments;
	}

	public void setComments(List<CommentDB> comments) {
		this.comments = comments;
	}
}
