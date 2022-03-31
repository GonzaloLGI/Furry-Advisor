package com.example.demo.Controladores;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.NewOffer;
import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Interfaces.DealDBInterface;
import com.example.demo.Interfaces.PlaceDBInterface;
import com.example.demo.Interfaces.ReviewDBInterface;
import com.example.demo.Interfaces.UserDBInterface;
import com.example.demo.Services.DealService;
import com.example.demo.Services.UserService;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML edit_profile
@Controller
public class AccountSettingsController implements CommandLineRunner {

	@Autowired
	public NewOffer newOffer;
	
	@Autowired
	private UserService userRepository;
	
	@Autowired
	private UserComponent component;
	
	@Autowired
	private DealService dealRepository;
	
	@GetMapping("/account_settings")
	public String account_settings( Model model,HttpSession http) {
		UserDB actualUser = component.getLoggedUser();
		model.addAttribute("user",actualUser);
		model.addAttribute("place",http.getAttribute("place"));
	    model.addAttribute("offer",http.getAttribute("offer"));
		return "account_settings";
	}
	
	@PostMapping("/changePassword")
	public ModelAndView changePassword(HttpSession http, Model model, @RequestParam String newPassword) {
	 
		UserDB actualUser = component.getLoggedUser();
				
		if(!newPassword.equals("")) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			
			actualUser.setPassword(encoder.encode(newPassword));
			http.setAttribute("actUser", actualUser);
			
			UserDB aux = userRepository.findByNickname(actualUser.getNickname()).get(0);
			aux.setPassword(actualUser.getPassword());
			userRepository.save(aux);
			
			List<DealDB> deals = dealRepository.findAllByPlaceOriginIsNotNull();
			int random1=(int)Math.random()*deals.size();
			int random2=(int)Math.random()*deals.size();
			
			DealDB dealDB1 = deals.get(random1);
			DealDB dealDB2 = deals.get(random2);
			if(dealDB1==dealDB2&&random2!=0) {
				dealDB2=deals.get(random2--);
			}else if(dealDB1==dealDB2) {
				dealDB2=deals.get(random2++);
			}
			
			
			model.addAttribute("place_name1", dealDB1.getPlaceOrigin().getName());
			model.addAttribute("place_name2", dealDB2.getPlaceOrigin().getName());
			model.addAttribute("deal_image1", dealDB1.getDealPic());
			model.addAttribute("deal_image2", dealDB2.getDealPic());
			model.addAttribute("deal_header1", dealDB1.getHeader());
			model.addAttribute("deal_header2", dealDB2.getHeader());
			
		}
			
		return new ModelAndView("redirect:/home");
	}
	
	
	@PostMapping("/delete")
	public ModelAndView delete(HttpSession http, Model model) {
		
		UserDB actualUser = component.getLoggedUser();
		userRepository.delete(actualUser);
		
		List<DealDB> deals = dealRepository.findAllByPlaceOriginIsNotNull();
		int random1=(int)Math.random()*deals.size();
		int random2=(int)Math.random()*deals.size();
		
		DealDB dealDB1 = deals.get(random1);
		DealDB dealDB2 = deals.get(random2);
		if(dealDB1==dealDB2&&random2!=0) {
			dealDB2=deals.get(random2--);
		}else if(dealDB1==dealDB2) {
			dealDB2=deals.get(random2++);
		}
		
		
		model.addAttribute("place_name1", dealDB1.getPlaceOrigin().getName());
		model.addAttribute("place_name2", dealDB2.getPlaceOrigin().getName());
		model.addAttribute("deal_image1", dealDB1.getDealPic());
		model.addAttribute("deal_image2", dealDB2.getDealPic());
		model.addAttribute("deal_header1", dealDB1.getHeader());
		model.addAttribute("deal_header2", dealDB2.getHeader());
		
		return new ModelAndView("redirect:/home");
	}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
