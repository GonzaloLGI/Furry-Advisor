package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.LocationDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Interfaces.PlaceDBInterface;

@Service
public class PlaceService {

	@Autowired
	private PlaceDBInterface placeRepository;
	
	public List<PlaceDB> findByName(String name){
		return placeRepository.findByName(name);
	}
	
	public List<PlaceDB> findByType(String type){
		return placeRepository.findByName(type);
	}
	
	public List<PlaceDB> findByCity(LocationDB loc){
		return placeRepository.findByCity(loc);
	}
	
	public List<PlaceDB> findByCityAndType(LocationDB city,String type){
		return placeRepository.findByCityAndType(city, type);
	}
}
