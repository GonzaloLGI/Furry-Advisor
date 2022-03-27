package com.example.demo.Controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.NewOffer;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Services.UserService;

@Controller
public class SearchAdminController {

	@Autowired
	public NewOffer newOffer;
	
	@Autowired
	private UserService userRepository;
	
	@GetMapping("/userSearch")
	public String userSearch(Model model,HttpSession http) {
        List<UserDB> allUsers = userRepository.findAll();
		model.addAttribute("users_list", allUsers);
		model.addAttribute("newoffer",newOffer.getNewOffer());
		return "search_admin";
	}
	
	@GetMapping("/searchByName")
	public String search(Model model, @RequestParam String filter, HttpSession http){
		List<UserDB> userName = userRepository.findByNickname(filter);
		model.addAttribute("users_list",userName);
	
		return "search_admin";
	}
}
