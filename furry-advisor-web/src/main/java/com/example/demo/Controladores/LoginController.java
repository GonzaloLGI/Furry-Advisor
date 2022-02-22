package com.example.demo.Controladores;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Interfaces.PlaceDBInterface;
import com.example.demo.Interfaces.ReviewDBInterface;
import com.example.demo.Interfaces.UserDBInterface;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML Login
@Controller
public class LoginController {
	 private Logger log = (Logger) LoggerFactory.getLogger(LoginController.class);
	 
	 @Autowired
	 private ReviewDBInterface reviewRepository;
	 @Autowired
	 private UserDBInterface userRepository;
	 @Autowired
	 private PlaceDBInterface placeRepository;
	 
	 @GetMapping("/login")
	 public String page(Model model) {
		 
		 log.trace("A TRACE Message");
		 log.debug("A DEBUG Message");
		 log.info("An INFO Message");
		 log.warn("A WARN Message");
		 log.error("An ERROR Message");
		 return "login";
		 
	 }
	 
	 @PostMapping("/accessProfile")
		public String login(HttpSession http, Model model, @RequestParam String userName, @RequestParam String userPassword) {
		 
			List<UserDB> userAux = userRepository.findByNickname(userName);
			
			if(userAux.size()>0) {
				if(userPassword.equals(userAux.get(0).getPassword())) {
					http.setAttribute("actUser", userAux.get(0));
					model.addAttribute("name", userName);
					model.addAttribute("password",userPassword);
					
					List<PlaceDB> places = placeRepository.findAll();
					model.addAttribute("n1",places.get(0).getName());
					model.addAttribute("t1",places.get(0).getType());
					model.addAttribute("v1",places.get(0).getRating());
					
					return "profile";
				}
				
				System.out.println("Contraseña incorrecta");
				return "login";
			}
			else {
				System.out.println("El usuario introducido no existe");
				return "login";
				
			}
			
	 }
}
