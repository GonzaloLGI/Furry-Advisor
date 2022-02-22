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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Clase de la entidad Place en la BD

@Entity
public class PlaceDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int place_id;
	
	@Column(nullable=false)
	private String name;
	@ManyToOne(cascade=CascadeType.ALL)
	private LocationDB city;
	@Column(nullable=false)
	private String address;
	private String description;
	@Column(nullable=false)
	private String type;
	@Column(nullable=false)
	private float rating;
	private String placeUrl;
	private String schedule;
	@Lob
	@JsonIgnore
	private Blob placePic;
	
	protected PlaceDB(){};
	
	public PlaceDB(String n, String t, LocationDB ct, String desc, String url, int r, String a, String sch, Blob photo) {
		name = n;
		type = t;
		setRating(r);
		address = a;
		city = ct;
		description = desc;
		placeUrl = url;
		placePic = photo;
		schedule = sch;
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
		return placeUrl;
	}

	public void setPlace_url(String place_url) {
		this.placeUrl = place_url;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public void setPlacePic(Blob photo) {
		this.placePic = photo;
	}
	
	public Blob getPlacePic() {
		return placePic;
	}

	public LocationDB getCity() {
		return city;
	}

	public void setCity(LocationDB city) {
		this.city = city;
	}
	
}
