package com.example.demo;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class CommentDB {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int comm_id;
	
	private String text;
	private Date date;
	private int usefness;
	@OneToOne
	private ReviewDB review_or;
	@OneToOne
	private UserDB user_or;
	
	public CommentDB() {};
	
	public CommentDB(int id, Date d, ReviewDB rev, UserDB us) {
		comm_id = id;
		setDate(d);
		setReview_or(rev);
		setUser_or(us);
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
