package com.example.demo.Controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Services.PlaceService;

@Controller
public class CreateReviewController {
	
	@Autowired
	private PlaceService placeRepository;
	

	@GetMapping("/create_review/{placeName}")
    public String createReview(Model model,HttpSession http, @PathVariable String placeName) {

        UserDB user=(UserDB)http.getAttribute("actUser");
        List<PlaceDB> placeList =placeRepository.findByName(placeName);
        PlaceDB place = null;
        if(placeList.size()>0) {
            place = placeList.get(0);
        }
        model.addAttribute("place_name", place.getName());



        return "create_review";
    }
	
}
