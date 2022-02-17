package com.example.demo.Entidades2;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@ManyToOne 
	private UserDB user_or;
	@ManyToOne
	private PlaceDB place_or;
	//Comprobar como iban las relaciones escritas en Spring
	/*@OneToMany(cascade=CascadeType.ALL)
	private List<CommentDB> comments;*/
	
	public ReviewDB() {};
	
	public ReviewDB(int id, int rt, String txt, Date dt, int usf, UserDB us, PlaceDB pl/*, List<CommentDB> comms*/) {
		rev_id = id;
		rating = rt;
		text = txt;
		date_r = dt;
		o_usefness = usf;
		user_or = us;
		place_or = pl;
		//comments = comms;
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

	/*public List<CommentDB> getComments() {
		return comments;
	}

	public void setComments(List<CommentDB> comments) {
		this.comments = comments;
	}*/
	
	public UserDB getUserOwn() {
		return user_or;
	}

	public void setUserOwn(UserDB user) {
		this.user_or = user;
	}
	
	public PlaceDB getPlaceOwn() {
		return place_or;
	}

	public void setPlaceOwn(PlaceDB place) {
		this.place_or = place;
	}
}
