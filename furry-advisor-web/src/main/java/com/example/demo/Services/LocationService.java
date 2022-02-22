package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.LocationDB;
import com.example.demo.Interfaces.LocationDBInterface;

@Service
public class LocationService {
	
	@Autowired
	private LocationDBInterface locationRepository;
	
	public List<LocationDB> findAll(){
		return locationRepository.findAll();
	}
	
	public List<LocationDB> findAllByOrderByName(){
		return locationRepository.findAllByOrderByName();
	}
	
	public List<LocationDB> findByName(String name){
		return locationRepository.findByName(name);
	}
}
