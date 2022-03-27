package com.example.demo.Controladores;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.example.demo.Services.PlaceService;
import com.example.demo.Services.ReviewService;
import com.example.demo.Services.UserService;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML edit_profile
@Controller
public class EditProfileController implements CommandLineRunner {

	@Autowired
	public NewOffer newOffer;

	@Autowired
	private UserService userRepository;
	
	@Autowired 
	private DealService dealRepository;
	
	@Autowired 
	private ReviewService reviewRepository;
	
	@RequestMapping("/edit_profile")
	public String edit_profile(HttpSession http, Model model) {
	 
		UserDB aux = (UserDB)http.getAttribute("actUser");
		UserDB actualUser = userRepository.findByNickname(aux.getNickname()).get(0);
		List<ReviewDB> reviews = reviewRepository.findByUserRef(actualUser);
		model.addAttribute("userName",actualUser.getNickname());
		model.addAttribute("user",actualUser);	
		model.addAttribute("place",http.getAttribute("place"));
	    model.addAttribute("offer",http.getAttribute("offer"));
		http.setAttribute("actUser", actualUser);
		model.addAttribute("newoffer",newOffer.getNewOffer());
		
		if(reviews!=null) {
			model.addAttribute("review_list", reviews);
		}					
		return "edit_profile";
	}
	
	@PostMapping("/changeNickname")
	public ModelAndView changeNickname(HttpSession http, Model model, @RequestParam String newNickname) {
	 
		UserDB actualUser = (UserDB)http.getAttribute("actUser");
				
		if(!newNickname.equals("")) {
			actualUser.setNickname(newNickname);
			http.setAttribute("actUser", actualUser);
			
			if(userRepository.findByNickname(actualUser.getNickname()).size()==0) {
				userRepository.save(actualUser);
				
			}
			
		}
		return new ModelAndView("redirect:/home");
	}
	
	@PostMapping("/upload_image")
	public ModelAndView uploadImage(HttpSession http,Model model, @RequestParam MultipartFile image) throws IOException {
		UserDB user = (UserDB)http.getAttribute("actUser");
		user.setProf_photo(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
		userRepository.save(user);
		
		List<DealDB> deals = dealRepository.findAllByPlaceOriginIsNotNull();
		int random1=(int)Math.random()*deals.size();
		int random2=(int)Math.random()*deals.size();
		
		
		//Para recargar
		List<ReviewDB> reviews = reviewRepository.findByUserRef(user);
		model.addAttribute("name",user.getNickname());
		if(reviews!=null) {
			model.addAttribute("review_list", reviews);
		}	
		
		return new ModelAndView("redirect:/home");
	}	
	
	@GetMapping("/deleteReviews")
	public ModelAndView deleteReviews(HttpSession http, Model model) {
		System.out.println("alo");
		UserDB aux = (UserDB)http.getAttribute("actUser");
		UserDB actualUser = userRepository.findByNickname(aux.getNickname()).get(0);
		List<ReviewDB> reviews = reviewRepository.findByUserRef(actualUser);
		
		for(int i = 0; i<reviews.size();i++) {
			reviewRepository.delete(reviews.get(i));
		}
		
		actualUser.setReviews(new ArrayList<>());
		userRepository.save(actualUser);
		
		return new ModelAndView("redirect:/home");
	}
	
	@GetMapping("/imageEditProfile")
	public ResponseEntity<Object> imageEditProfile(HttpSession http, Model model) throws MalformedURLException, SQLException {
		UserDB user = (UserDB)http.getAttribute("actUser");
		if (user.getProf_photo() != null) {
			Resource image = new InputStreamResource(user.getProf_photo().getBinaryStream());
			return ResponseEntity.ok()
					 .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
					 .contentLength(user.getProf_photo().length())
					 .body(image);
		}else {
			System.out.println("No hay foto");
			return  ResponseEntity.notFound().build();
		}
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
