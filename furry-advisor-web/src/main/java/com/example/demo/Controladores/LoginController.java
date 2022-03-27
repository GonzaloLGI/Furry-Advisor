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
import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Interfaces.PlaceDBInterface;
import com.example.demo.Interfaces.ReviewDBInterface;
import com.example.demo.Interfaces.UserDBInterface;
import com.example.demo.Services.PlaceService;
import com.example.demo.Services.ReviewService;
import com.example.demo.Services.UserService;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML Login
@Controller
public class LoginController {
	 private Logger log = (Logger) LoggerFactory.getLogger(LoginController.class);

	@Autowired
	public NewOffer newOffer;

	 @Autowired
	 private ReviewService reviewRepository;
	 
	 @Autowired
	 private UserService userRepository;
	 
	 @GetMapping("/login")
	 public String page(Model model,HttpSession http) {
		 model.addAttribute("place",http.getAttribute("place"));
	     model.addAttribute("offer",http.getAttribute("offer"));
		 model.addAttribute("newoffer",newOffer.getNewOffer());
		 return "login";
		 
	 }
	 
	 //ESTO ES INUTIL CON SPRING SECURITY. BORRAR
	 @GetMapping("/accessProfile")
		public String login(HttpSession http, Model model, @RequestParam String userName, @RequestParam String userPassword) {
		 
			List<UserDB> userAux = userRepository.findByNickname(userName);
			
			if(userAux.size()>0) {
				if(userPassword.equals(userAux.get(0).getPassword())) {
					http.setAttribute("actUser", userAux.get(0));
					model.addAttribute("name", userName);
					model.addAttribute("password",userPassword);
					
					List<ReviewDB> revs = reviewRepository.findByUserRef(userAux.get(0));
					if(revs.size()>0) {
						model.addAttribute("user_reviews",revs);
					}
					return "profile/"+userName;
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
