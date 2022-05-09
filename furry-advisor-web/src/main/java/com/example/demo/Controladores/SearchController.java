package com.example.demo.Controladores;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.NewOffer;
import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.LocationDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.PlaceTypeDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Interfaces.LocationDBInterface;
import com.example.demo.Interfaces.PlaceDBInterface;
import com.example.demo.Services.LocationService;
import com.example.demo.Services.PlaceService;
import com.example.demo.Services.PlaceTypeService;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML Search
@Controller
public class SearchController implements CommandLineRunner {
	
	@Autowired
	private UserComponent component;
	
	@Autowired
	private PlaceService placeRepository;
	
	@Autowired
	private LocationService locationRepository;
	
	@Autowired
	private PlaceTypeService placeTypeRepository;
	
	@Autowired
	private NewOffer newOffer;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}

	@GetMapping("/searchPlatform")
	public String searchPlatform(Model model,HttpSession http) {
		UserDB actualUser = component.getLoggedUser();
		model.addAttribute("user",actualUser);
		List<LocationDB> allLocations = locationRepository.findAllByOrderByName();
		model.addAttribute("location_list", allLocations);
		List<PlaceTypeDB> allTypes = placeTypeRepository.findAllByOrderByType();
		model.addAttribute("types_list", allTypes);
		List<PlaceDB> allPlaces = placeRepository.findAll();
		model.addAttribute("places_list", allPlaces);
		model.addAttribute("place",http.getAttribute("place"));
	    model.addAttribute("offer",http.getAttribute("offer"));
	    model.addAttribute("newoffer",newOffer.getNewOffer());
		return "search";
	}
	
	
	@GetMapping("/search")
	public String search(Model model, @RequestParam String locationFilter, @RequestParam String typeFilter, HttpSession http) { 
		List<LocationDB> allLocations = locationRepository.findAllByOrderByName();
		model.addAttribute("location_list", allLocations);
		List<PlaceTypeDB> allTypes = placeTypeRepository.findAllByOrderByType();
		model.addAttribute("types_list", allTypes);
		
		List<PlaceDB> placesFilteredByLocation = null;
		List<PlaceDB> placesFilteredByType = null;
		List<PlaceDB> placesSuperFiltered2 = null;
		List<PlaceDB> allPlaces = null;
		
		if(!typeFilter.equals("")&&!locationFilter.equals("")) {
			List<LocationDB> listAux = locationRepository.findByName(locationFilter);
			List<PlaceTypeDB> listAux2 = placeTypeRepository.findByType(typeFilter);
			placesSuperFiltered2 = placeRepository.findByCityAndType(listAux.get(0),listAux2.get(0));
		}
		
		else if(!locationFilter.equals("")) {
			List<LocationDB> listAux = locationRepository.findByName(locationFilter);
			placesFilteredByLocation = placeRepository.findByCity(listAux.get(0));
		}
		else if(!typeFilter.equals("")) {
			List<PlaceTypeDB> listAux2 = placeTypeRepository.findByType(typeFilter);
			placesFilteredByType = placeRepository.findByType(listAux2.get(0));
		}
		else {
			allPlaces = placeRepository.findAll();
		}
		
		
		
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
		
		model.addAttribute("place",http.getAttribute("place"));
	    model.addAttribute("offer",http.getAttribute("offer"));
		
	    return "search";
	}
	
	@GetMapping("/image/{name}")
	public ResponseEntity<Object> downloadImage(Model model, @PathVariable String name) throws MalformedURLException, SQLException {
		PlaceDB place = placeRepository.findByName(name).get(0);
		if (place.getPlacePic() != null) {
			Resource image = new InputStreamResource(place.getPlacePic().getBinaryStream());
			return ResponseEntity.ok()
					 .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
					 .contentLength(place.getPlacePic().length())
					 .body(image);
		}else {
			System.out.println("No hay foto");
			return  ResponseEntity.notFound().build();
		}
		
	}
	
}
