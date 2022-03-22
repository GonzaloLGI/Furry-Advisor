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

import com.example.demo.Entidades.PlaceDB.Basico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

//Clase de la entidad Place en la BD

@Entity
public class PlaceDB {

	public interface Basico{}
	
	@Id
	@JsonView(Basico.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int place_id;
	
	@JsonView(Basico.class)
	@Column(nullable=false)
	private String name;
	
	@JsonView(Basico.class)
	@ManyToOne
	private LocationDB city;
	
	@JsonView(Basico.class)
	@Column(nullable=false)
	private String address;
	
	@JsonView(Basico.class)
	private String description;
	
	@JsonIgnore
	@ManyToOne
	private PlaceTypeDB type;
	
	@JsonView(Basico.class)
	@Column(nullable=false)
	private float rating;
	
	@JsonView(Basico.class)
	private String placeUrl;
	
	@JsonView(Basico.class)
	private String schedule;
	
	@Lob
	@JsonIgnore
	private Blob placePic;
	
	protected PlaceDB(){};
	
	public PlaceDB(String n, PlaceTypeDB t, LocationDB ct, String desc, String url, int r, String a, String sch, Blob photo) {
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

	public PlaceTypeDB getType() {
		return type;
	}

	public void setType(PlaceTypeDB type) {
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
	
	public String getPlaceUrl() {
		return placeUrl;
	}

	public void setPlaceUrl(String placeUrl) {
		this.placeUrl = placeUrl;
	}
}
