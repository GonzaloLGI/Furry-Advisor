package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PlaceDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int place_id;
	
	private String name;
	private String address;
	private String description;
	private String type;
	private float rating;
	private String place_url;
	private String schedule;
	/*@OneToMany(cascade=CascadeType.ALL)
	private List<DealDB> deals;
	@OneToMany(cascade=CascadeType.ALL)
	private List<ReviewDB> reviews;*/
	
	protected PlaceDB(){};
	
	public PlaceDB(int i, String n, String t, int r, String a/*, List<DealDB> dealz, List<ReviewDB> revs*/) {
		place_id = i;
		name = n;
		type = t;
		setRating(r);
		address = a;
		/*deals = dealz;
		reviews = revs;*/
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(int score) {
		this.rating = score;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getPlace_url() {
		return place_url;
	}

	public void setPlace_url(String place_url) {
		this.place_url = place_url;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	/*public List<DealDB> getDeals() {
		return deals;
	}

	public void setDeals(List<DealDB> deals) {
		this.deals = deals;
	}

	public List<ReviewDB> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDB> reviews) {
		this.reviews = reviews;
	}*/
	
}
