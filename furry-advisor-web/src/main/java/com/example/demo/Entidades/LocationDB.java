package com.example.demo.Entidades;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;





//Clase de la entidad Location en la BD
@Entity
public class LocationDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int location_id;
	
	@Column(nullable=false)
	private String name;
	
	
	//private List<PlaceDB> places;
	
	
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
