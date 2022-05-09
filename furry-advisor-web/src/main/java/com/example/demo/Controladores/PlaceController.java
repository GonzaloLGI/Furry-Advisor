package com.example.demo.Controladores;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.example.demo.ImageUtils;
import com.example.demo.NewOffer;
import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.LocationDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Services.DealService;
import com.example.demo.Services.LocationService;
import com.example.demo.Services.PlaceService;
import com.example.demo.Services.ReviewService;
import com.example.demo.Services.UserService;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML Place
@Controller
public class PlaceController {

	@Autowired
	private UserComponent component;
	
	@Autowired
	public NewOffer newOffer;

	@Autowired
	private UserService userRepository;
	
	@Autowired
	private PlaceService placeRepository;
	
	@Autowired
	private DealService dealRepository;
	
	@Autowired
	private LocationService locationRepository;
	
	@Autowired
	private ReviewService reviewRepository;
	

	
	
	@GetMapping("/place/{place_name}")
	public String place(Model model,HttpSession http, @PathVariable String place_name, HttpServletRequest request) {  
		UserDB actualUser = component.getLoggedUser();
		model.addAttribute("user",actualUser);
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
			model.addAttribute("newoffer",newOffer.getNewOffer());
		    List<LocationDB> auxCity = locationRepository.findByName(aux.getCity().getName());
		    model.addAttribute("city",auxCity.get(0).getName());
		    List<DealDB> deals = dealRepository.findAllByPlaceOrigin(aux);
		    model.addAttribute("deal_list",deals);
		    List<ReviewDB> reviews = reviewRepository.findByPlacRef(aux);
		    int rate=0;
		    if(reviews.size()>0) {
		    	
		    	for(int i = 0; i<reviews.size();i++) {
		    		rate+= reviews.get(i).getRating();
		    	}
		    	rate = rate/reviews.size();
		    	
	    	}
		    model.addAttribute("placeRating",rate);
		    model.addAttribute("reviews_list",reviews);
		    
		    model.addAttribute("admin",request.isUserInRole("ADMIN"));
		    
		    model.addAttribute("place",http.getAttribute("place"));
		    model.addAttribute("offer",http.getAttribute("offer"));
	    }
	    
	    return "place";
	}
	
	@GetMapping("/dealImage/{header}")
	public ResponseEntity<Object> dealImage(Model model, @PathVariable String header) throws MalformedURLException, SQLException {
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
	@GetMapping("/userImage/{header}")
	public ResponseEntity<Object> userImage(Model model, @PathVariable String header) throws MalformedURLException, SQLException {
		List<UserDB> profiles = userRepository.findByNickname(header);
		UserDB user = profiles.get(0);
		if (user.getProf_photo() != null) {
			Resource image = ImageUtils.imageStringToResource(user.getProf_photo());
			return ResponseEntity.ok()
					 .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
					 .contentLength(user.getProf_photo().length())
					 .body(image);
		}else {
			System.out.println("No hay foto");
			return  ResponseEntity.notFound().build();
		}
		
	}

}
