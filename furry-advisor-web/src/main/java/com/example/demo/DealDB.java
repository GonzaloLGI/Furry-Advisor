package com.example.demo;

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
	private Blob deal_p;
	@ManyToOne //Habria un problema de que objeto se crea primero: place o deal
	private PlaceDB place_or;
	
	public DealDB() {};
	
	public DealDB(int id, String h, PlaceDB pl) {
		deal_id = id;
		place_or = pl;
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

	public Blob getDeal_p() {
		return deal_p;
	}

	public void setDeal_p(Blob deal_p) {
		this.deal_p = deal_p;
	}

	public PlaceDB getPlace_or() {
		return place_or;
	}

	public void setPlace_or(PlaceDB place_or) {
		this.place_or = place_or;
	}
}
