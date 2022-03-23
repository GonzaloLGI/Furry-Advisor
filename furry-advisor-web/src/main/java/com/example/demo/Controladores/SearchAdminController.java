package com.example.demo.Controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entidades.UserDB;
import com.example.demo.Services.UserService;

@Controller
public class SearchAdminController {
	
	@Autowired
	private UserService userRepository;
	
	@GetMapping("/userSearch")
	public String userSearch(Model model,HttpSession http) {
		model.addAttribute("place", http.getAttribute("place"));
        model.addAttribute("offer", http.getAttribute("offer"));
        List<UserDB> allUsers = userRepository.findAll();
		model.addAttribute("users_list", allUsers);
		return "search_admin";
	}
}
