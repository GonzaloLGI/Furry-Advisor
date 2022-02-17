package com.example.demo.Entidades;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DealDB {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int deal_id;
	
	private String header;
	private String description;
	private Blob dealPic;
	@ManyToOne //Habria un problema de que objeto se crea primero: place o deal
	private PlaceDB placeOrigin;
	
	public DealDB() {};
	
	public DealDB(int id, String h, PlaceDB pl) {
		deal_id = id;
		placeOrigin = pl;
		setHeader(h);
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getDealPic() {
		return dealPic;
	}

	public void setDealPic(Blob deal_p) {
		this.dealPic = deal_p;
	}

	public PlaceDB getPlaceOrigin() {
		return placeOrigin;
	}

	public void setPlaceOrigin(PlaceDB place_or) {
		this.placeOrigin = place_or;
	}
}
