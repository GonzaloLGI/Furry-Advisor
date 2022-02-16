package com.example.demo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CommentDB {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int comm_id;
	
	private String text;
	@Temporal(TemporalType.DATE)
	private Date date;
	private int usefness;
	@ManyToOne
	private UserDB user_or;
	@ManyToOne
	private ReviewDB review_or;
	
	public CommentDB() {};
	
	public CommentDB(int id, Date d, UserDB us, ReviewDB rv) {
		comm_id = id;
		setDate(d);
		setUser_or(us);
		review_or = rv;
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
		return usefness;
	}

	public void setUsefness(int usefness) {
		this.usefness = usefness;
	}

	public ReviewDB getReview_or() {
		return review_or;
	}

	public void setReview_or(ReviewDB review_or) {
		this.review_or = review_or;
	}

	public UserDB getUser_or() {
		return user_or;
	}

	public void setUser_or(UserDB user_or) {
		this.user_or = user_or;
	}
}
