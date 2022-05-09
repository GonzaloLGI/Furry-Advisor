package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.LocationDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.PlaceTypeDB;
import com.example.demo.Interfaces.PlaceDBInterface;

@Service
public class PlaceService {

	@Autowired
	private PlaceDBInterface placeRepository;
	
	public List<PlaceDB> findByName(String name){
		return placeRepository.findByName(name);
	}
	
	public List<PlaceDB> findByType(PlaceTypeDB type){
		return placeRepository.findByType(type);
	}
	
	public List<PlaceDB> findByCity(LocationDB loc){
		return placeRepository.findByCity(loc);
	}
	
	public List<PlaceDB> findByCityAndType(LocationDB city,PlaceTypeDB placeTypeDB){
		return placeRepository.findByCityAndType(city, placeTypeDB);
	}
	
	public void save(PlaceDB place){
		placeRepository.save(place);
	}

	@Cacheable("places")
	public List<PlaceDB> findAll(){
		return placeRepository.findAll();
	}
}
