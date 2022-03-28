package com.example.demo.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.NewOffer;
import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Services.DealService;
import com.example.demo.Services.PlaceService;

@Controller
public class CreateDeals {

	@Autowired
	public NewOffer newOffer;

	@Autowired
	private DealService dealRepository;
	
	@Autowired
	private PlaceService placeRepository;
	
	@GetMapping("/createDeal/{placeName}")
	public String creatDeal(Model model, @PathVariable String placeName) {
		model.addAttribute("place_name",placeName);
		model.addAttribute("newoffer",newOffer.getNewOffer());
		return "create_deal";
	}
	
	/*@PostMapping("/addNewDeal/{place_name}")
	public ModelAndView addDeal(Model model, @RequestParam String header, @RequestParam String description, @PathVariable String place_name) {
		PlaceDB place = placeRepository.findByName(place_name).get(0);
		DealDB newDeal = new DealDB(header,description,null,place);
		dealRepository.save(newDeal);
		return new ModelAndView(("redirect:/place/"+place_name));
	}*/
}
