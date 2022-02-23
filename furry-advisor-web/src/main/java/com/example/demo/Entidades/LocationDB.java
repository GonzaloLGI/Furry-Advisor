package com.example.demo.Entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Clase de la entidad Location en la BD
@Entity
public class LocationDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int location_id;
	
	@Column(nullable=false)
	private String name;
	
	protected LocationDB(){};
	
	public LocationDB(String n) {
		name = n;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
