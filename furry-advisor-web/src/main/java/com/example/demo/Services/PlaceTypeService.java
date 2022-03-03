package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.LocationDB;
import com.example.demo.Entidades.PlaceTypeDB;
import com.example.demo.Interfaces.LocationDBInterface;
import com.example.demo.Interfaces.PlaceTypeDBInterface;

@Service
public class PlaceTypeService {
	
	@Autowired
	private PlaceTypeDBInterface PlaceTypeRepository;
	
	public List<PlaceTypeDB> findAll(){
		return PlaceTypeRepository.findAll();
	}
	
	public List<PlaceTypeDB> findAllByOrderByType(){
		return PlaceTypeRepository.findAllByOrderByType();
	}
	
	public List<PlaceTypeDB> findByType(String type){
		return PlaceTypeRepository.findByType(type);
	}
	
	public void save(PlaceTypeDB type){
		PlaceTypeRepository.save(type);
	}
}
