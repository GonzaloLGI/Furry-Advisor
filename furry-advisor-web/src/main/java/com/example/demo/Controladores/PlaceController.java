package com.example.demo.Controladores;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.LocationDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Interfaces.DealDBInterface;
import com.example.demo.Interfaces.LocationDBInterface;
import com.example.demo.Interfaces.PlaceDBInterface;
import com.example.demo.Services.DealService;
import com.example.demo.Services.LocationService;
import com.example.demo.Services.PlaceService;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML Place
@Controller
public class PlaceController {

	@Autowired
	private PlaceService placeRepository;
	
	@Autowired
	private DealService dealRepository;
	
	@Autowired
	private LocationService locationRepository;
	
	
	@GetMapping("/place/{place_name}")
	public String place(Model model, @PathVariable String place_name) {    
	    List<PlaceDB> places = placeRepository.findByName(place_name);
	    if(places.size()>0) {
	    	PlaceDB aux = places.get(0);
		    model.addAttribute("place_name",aux.getName());
		    model.addAttribute("place_address",aux.getAddress());
		    model.addAttribute("place_desc",aux.getDescription());
		    model.addAttribute("place_type",aux.getType());
		    model.addAttribute("place_rating",aux.getRating());
		    model.addAttribute("place_url",aux.getPlace_url());
		    model.addAttribute("place_schedule",aux.getSchedule());
		    List<LocationDB> auxCity = locationRepository.findByName(aux.getCity().getName());
		    model.addAttribute("city",auxCity.get(0).getName());
		    List<DealDB> deals = dealRepository.findAllByPlaceOrigin(aux);
		    model.addAttribute("deal_list",deals);
	    }
	    
	    return "place";
	}
	
	@GetMapping("/dealImage/{header}")
	public ResponseEntity<Object> dealImage(HttpSession http, Model model, @PathVariable String header) throws MalformedURLException, SQLException {
		List<DealDB> deals = dealRepository.findByHeader(header);
		DealDB dealDB1 = deals.get(0);
		System.out.println(dealDB1.getHeader());
		if (dealDB1.getDealPic() != null) {
			Resource image = new InputStreamResource(dealDB1.getDealPic().getBinaryStream());
			return ResponseEntity.ok()
					 .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
					 .contentLength(dealDB1.getDealPic().length())
					 .body(image);
		}else {
			System.out.println("No hay foto");
			return  ResponseEntity.notFound().build();
		}
		
	}

}
