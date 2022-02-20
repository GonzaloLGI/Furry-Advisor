package com.example.demo.Entidades;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DealDB {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int deal_id;
	
	@Column(nullable=false)
	private String header;
	private String description;
	@Lob
	@JsonIgnore
	private Blob dealPic;
	@ManyToOne
	private PlaceDB placeOrigin;
	
	public DealDB() {};
	
	public DealDB(/*int id,*/ String h, String desc, Blob photo, PlaceDB pl) {
		/*deal_id = id;*/
		placeOrigin = pl;
		setHeader(h);
		description = desc;
		dealPic = photo;
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
