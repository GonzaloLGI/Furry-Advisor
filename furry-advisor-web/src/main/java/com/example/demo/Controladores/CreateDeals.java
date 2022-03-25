package com.example.demo.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entidades.DealDB;
import com.example.demo.Services.DealService;

@Controller
public class CreateDeals {

	@Autowired
	private DealService dealRepository;
	
	@PostMapping("/addNewDeal")
	public ModelAndView addDeal(Model model, @RequestParam String header, @RequestParam String description) {
		DealDB newDeal = new DealDB(header,description,null,null);
		dealRepository.save(newDeal);
		return new ModelAndView("rediretc:/home");
	}
}
