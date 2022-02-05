package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
	
	@PostMapping("/profile")
	public String profile(Model model, @RequestParam String 
	userName) {
	 model.addAttribute("name", userName);
	 return "userPage";
	}
}
