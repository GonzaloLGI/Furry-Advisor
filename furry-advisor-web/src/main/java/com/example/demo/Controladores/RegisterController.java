package com.example.demo.Controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Interfaces.PlaceDBInterface;
import com.example.demo.Interfaces.UserDBInterface;

@Controller
public class RegisterController {
	
	@Autowired
	private UserDBInterface userRepository;
	@Autowired 
	private PlaceDBInterface placeRepository;

	@PostMapping("/createProfile")
	public String profile(HttpSession http, Model model, @RequestParam String userName, @RequestParam String userPassword) {
	 
		List<UserDB> userAux = userRepository.findByNickname(userName);
		
		if(!userAux.isEmpty()) {
			System.out.println("Este usuario ya existe");
			return "login";
		}
		else {
		
				//http.setAttribute("actUser", actualUser);
				UserDB newUser = new UserDB(userName,userPassword,null,null);
				userRepository.save(newUser);
				
				model.addAttribute("name", userName);
				model.addAttribute("password",userPassword);
				
		
				List<PlaceDB> places = placeRepository.findAll();
				model.addAttribute("n1",places.get(0).getName());
				model.addAttribute("t1",places.get(0).getType());
				model.addAttribute("v1",places.get(0).getRating());
		
				return "profile";
			
		}
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		
		
		
		return "register";
	}
}
