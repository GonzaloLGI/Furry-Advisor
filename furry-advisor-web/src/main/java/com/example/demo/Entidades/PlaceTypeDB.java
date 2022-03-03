package com.example.demo.Entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Clase de la entidad PlaceType en la BD
@Entity
public class PlaceTypeDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int placeType_id;
	
	@Column(nullable=false,unique=true)
	private String type;
	
	protected PlaceTypeDB(){};
	
	public PlaceTypeDB(String n) {
		type = n;
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
