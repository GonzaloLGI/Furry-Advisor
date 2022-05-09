package com.example.demo.Entidades;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DealDBJson implements Serializable{
	
	private String placeName;
	private String header;
	private String description;
	
	public DealDBJson (@JsonProperty("header") String header, @JsonProperty("description") String description, @JsonProperty("place_name") String place_name) {
		this.header = header;
		this.description = description;
		placeName = place_name;
	}
	
	public String getPlaceName() {
		return placeName;
	}


	public void setPlaceName(String placeName) {
		this.placeName = placeName;
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

}
