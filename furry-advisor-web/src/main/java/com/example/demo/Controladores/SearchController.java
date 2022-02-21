package com.example.demo.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.LocationDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Interfaces.LocationDBInterface;
import com.example.demo.Interfaces.PlaceDBInterface;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML Search
@Controller
public class SearchController implements CommandLineRunner {
	@Autowired
	private PlaceDBInterface placeRepository;
	
	@Autowired
	private LocationDBInterface locationRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<PlaceDB> places = placeRepository.findByType("Club");
		//System.out.println(places.get(0).getRating());
	}
	
	@GetMapping("/search")
	public String search(Model model, @RequestParam LocationDB locationFilter, @RequestParam String typeFilter) { 
		List<LocationDB> allLocations = locationRepository.findAllDesc();
		model.addAttribute("location_list", allLocations);
		
		
		List<PlaceDB> placesFilteredByLocation = placeRepository.findByCity(locationFilter.getName());
		List<PlaceDB> placesFilteredByType = placeRepository.findByType(typeFilter);
		List<PlaceDB> placesSuperFiltered2 = placeRepository.findByCityAndType(locationFilter.getName(),typeFilter);
		//List<PlaceDB> placesSuperFiltered = ((PlaceDBInterface) placesFilteredByLocation).findByType(typeFilter);
		
		List<PlaceDB> allPlaces = placeRepository.findAll();
		
		
		if(placesSuperFiltered2!=null) {
			model.addAttribute("places_list", placesSuperFiltered2);
		}
		else if(placesFilteredByLocation!=null) {
			model.addAttribute("places_list", placesFilteredByLocation);
		}
		else if(placesFilteredByType!=null) {
			model.addAttribute("places_list", placesFilteredByType);
		}
		else {
			model.addAttribute("places_list", allPlaces);
		}
		
	    return "search";
	}
	
	
}
