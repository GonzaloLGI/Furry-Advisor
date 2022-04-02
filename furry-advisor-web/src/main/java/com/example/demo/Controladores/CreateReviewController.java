package com.example.demo.Controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.NewOffer;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Services.PlaceService;
import com.example.demo.Services.UserService;

//Clase que se encarga de gestionar las peticiones hacia CreateReview
@Controller
public class CreateReviewController {

	@Autowired
	public NewOffer newOffer;
	
	@Autowired
	private UserComponent component;
	
	@Autowired
	private PlaceService placeRepository;
	@Autowired
	private UserService userRepository;
	
	private PlaceDB pl;

	@GetMapping("/create_review/{placeName}")
    public String createReview(Model model,HttpSession http, @PathVariable String placeName) {
        UserDB user=component.getLoggedUser();
        List<PlaceDB> placeList =placeRepository.findByName(placeName);
        PlaceDB place = null;
        if(placeList.size()>0) {
            place = placeList.get(0);
            pl = place;
        }
        model.addAttribute("place_name", place.getName());
        model.addAttribute("place",http.getAttribute("place"));
	    model.addAttribute("offer",http.getAttribute("offer"));
		model.addAttribute("newoffer",newOffer.getNewOffer());



        return "create_review";
    }
	
	
	@PostMapping("/confirmReview")
	public ModelAndView confirmReview(Model model, @RequestParam int rating,
			@RequestParam String review) throws ParseException {
		Date dt = new SimpleDateFormat("yyyy-MM-dd").parse("2022-04-20");
		ReviewDB rev = new ReviewDB(rating,review,dt,0,null,null);
		UserDB actualUser = component.getLoggedUser();
		
		rev.setPlaceOwn(pl);
		rev.setUserOwn(actualUser);
		List<ReviewDB> userReviews = actualUser.getReviews();
		userReviews.add(rev);
		actualUser.setReviews(userReviews);
		
		userRepository.save(actualUser);
		
		return new ModelAndView("redirect:/home");
	}
	
}
