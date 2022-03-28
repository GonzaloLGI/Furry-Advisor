package com.example.demo.Entidades;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

//Clase de la entidad Deal en la BD
@Entity
public class DealDB {
	
	public interface Basico{}
	public interface Completo{}
	
	@Id
	@JsonView(Basico.class)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int deal_id;
	
	@JsonView(Basico.class)
	@Column(nullable=false)
	private String header;
	
	@JsonView(Basico.class)
	private String description;
	
	@JsonView(DealDB.Completo.class)
	@Lob
	private Blob dealPic;
	
	@JsonView(DealDB.Completo.class)
	@ManyToOne
	private PlaceDB placeOrigin;
	
	public DealDB() {};
	
	public DealDB(String h, String desc, Blob photo, PlaceDB pl) {
		placeOrigin = pl;
		setHeader(h);
		description = desc;
		dealPic = photo;
	}
	
	public DealDB(String h, String desc, PlaceDB pl) {
		placeOrigin = pl;
		description = desc;
		setHeader(h);
	}

	public int getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(int deal_id) {
		this.deal_id = deal_id;
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
