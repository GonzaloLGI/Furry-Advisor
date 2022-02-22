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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Interfaces.DealDBInterface;
import com.example.demo.Interfaces.PlaceDBInterface;
import com.example.demo.Interfaces.ReviewDBInterface;
import com.example.demo.Interfaces.UserDBInterface;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML edit_profile
@Controller
public class AccountSettingsController implements CommandLineRunner {
	
	
	@Autowired
	private UserDBInterface userRepository;
	
	@Autowired
	private DealDBInterface dealRepository;
	
	@GetMapping("/account_settings")
	public String account_settings( Model model) {
	 
		return "account_settings";
	}
	
	@PostMapping("/changePassword")
	public String changePassword(HttpSession http, Model model, @RequestParam String newPassword) {
	 
		UserDB actualUser = (UserDB)http.getAttribute("actUser");
				
		if(!newPassword.equals("")) {
			actualUser.setPassword(newPassword);
			http.setAttribute("actUser", actualUser);
		}
			
		return "account_settings";
	}
	@PostMapping("/save")
	public String save(HttpSession http, Model model) {
		
		UserDB aux = (UserDB)http.getAttribute("actUser");
		UserDB actualUser = userRepository.findByNickname(aux.getNickname()).get(0);
		actualUser.setPassword(aux.getPassword());
		userRepository.save(actualUser);
		
		List<DealDB> deals = dealRepository.findAllByPlaceOriginIsNotNull();
		int numaux=(int)Math.random()*deals.size();
		int aux2=(int)Math.random()*deals.size();
		
		DealDB dealDB1 = deals.get(0);
		DealDB dealDB2 = deals.get(2);
		if(dealDB1==dealDB2&&aux2!=0) {
			dealDB2=deals.get(aux2--);
		}else if(dealDB1==dealDB2) {
			dealDB2=deals.get(aux2++);
		}
		
		
		model.addAttribute("place_name1", dealDB1.getPlaceOrigin().getName());
		model.addAttribute("place_name2", dealDB2.getPlaceOrigin().getName());
		model.addAttribute("deal_image1", dealDB1.getDealPic());
		model.addAttribute("deal_image2", dealDB2.getDealPic());
		model.addAttribute("deal_header1", dealDB1.getHeader());
		model.addAttribute("deal_header2", dealDB2.getHeader());
		
		return "home";
	}
	
	@PostMapping("/delete")
	public String delete(HttpSession http, Model model) {
		
		UserDB actualUser = (UserDB)http.getAttribute("actUser");
		userRepository.delete(actualUser);
		
		List<DealDB> deals = dealRepository.findAllByPlaceOriginIsNotNull();
		DealDB dealDB1 = deals.get(0);
		DealDB dealDB2 = deals.get(2);
		
		
		model.addAttribute("place_name1", dealDB1.getPlaceOrigin().getName());
		model.addAttribute("place_name2", dealDB2.getPlaceOrigin().getName());
		model.addAttribute("deal_image1", dealDB1.getDealPic());
		model.addAttribute("deal_image2", dealDB2.getDealPic());
		model.addAttribute("deal_header1", dealDB1.getHeader());
		model.addAttribute("deal_header2", dealDB2.getHeader());
		
		return "home";
	}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
