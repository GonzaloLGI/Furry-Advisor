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
public class EditProfileController implements CommandLineRunner {
	
	private static final Path IMAGES_FOLDER = Paths.get(System.getProperty("user.dir"),"images");
	@Autowired
	private UserDBInterface userRepository;
	@Autowired 
	private PlaceDBInterface placeRepository;
	@Autowired 
	private DealDBInterface dealRepository;
	@Autowired 
	private ReviewDBInterface reviewRepository;
	
	@PostMapping("/edit_profile")
	public String edit_profile(HttpSession http, Model model) {
	 
		UserDB aux = (UserDB)http.getAttribute("actUser");
		UserDB actualUser = userRepository.findByNickname(aux.getNickname()).get(0);
		List<ReviewDB> reviews = reviewRepository.findByUserRef(actualUser);
		model.addAttribute("name",actualUser.getNickname());
			
		http.setAttribute("actUser", actualUser);
		
		if(reviews!=null) {
			model.addAttribute("review_list", reviews);
		}					
		return "edit_profile";
	}
	
	@PostMapping("/changeNickname")
	public String changeNickname(HttpSession http, Model model, @RequestParam String newNickname) {
	 
		UserDB actualUser = (UserDB)http.getAttribute("actUser");
				
		if(!newNickname.equals("")) {
			actualUser.setNickname(newNickname);
			http.setAttribute("actUser", actualUser);
			
			if(userRepository.findByNickname(actualUser.getNickname()).size()>0) {
				UserDB aux = userRepository.findByNickname(actualUser.getNickname()).get(0);
				aux.setNickname(actualUser.getNickname());
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
			
		}
		return "home";
	}
	
	@PostMapping("/upload_image")
	public String uploadImage(HttpSession http,Model model, @RequestParam MultipartFile image) throws IOException {
		UserDB user = (UserDB)http.getAttribute("actUser");
		user.setProf_photo(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
		userRepository.save(user);
		
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
		
		return "home";
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
