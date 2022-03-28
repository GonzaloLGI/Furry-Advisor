package com.example.demo.Controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.NewOffer;
import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Services.ReviewService;
import com.example.demo.Services.UserService;

@Controller
public class EditUserController {
	
	private static final Path IMAGES_FOLDER = Paths.get(System.getProperty("user.dir"),"images");

	@Autowired
	public NewOffer newOffer;
	
	@Autowired
	public UserService userRepository;
	
	@Autowired
	private ReviewService reviewRepository;
	
	@GetMapping("/editUser/{nickname}")
	public String editUser(Model model, HttpSession http, @PathVariable String nickname) {
		UserDB user = userRepository.findByNickname(nickname).get(0);
		model.addAttribute("place", http.getAttribute("place"));
        model.addAttribute("offer", http.getAttribute("offer"));
        model.addAttribute("user_name", nickname);
        model.addAttribute("user_password", user.getPassword());
		model.addAttribute("newoffer",newOffer.getNewOffer());
		return "edit_user";
	}
	
	@PostMapping("/deleteUser/{nickname}")
	public ModelAndView delete(@PathVariable String nickname, Model model) {
		
		UserDB actualUser = userRepository.findByNickname(nickname).get(0);
		userRepository.delete(actualUser);
		
		return new ModelAndView("redirect:/userSearch");
	}
	
	@PostMapping("/deleteUserImage/{nickname}")
	public ModelAndView uploadImage(@PathVariable String nickname, Model model) throws IOException {
		UserDB user = userRepository.findByNickname(nickname).get(0);
		
		Path image_path = IMAGES_FOLDER.resolve("unknown.jpg");
		File imagen = new File(image_path.toUri());
		FileInputStream input = new FileInputStream(imagen);
		
		user.setProf_photo(BlobProxy.generateProxy(input, Files.size(image_path)));
		userRepository.save(user);
		
		return new ModelAndView(("redirect:/editUser/"+nickname));
	}
	
	@GetMapping("/getUserProfileImage/{user_name}")
	public ResponseEntity<Object> getUserProfileImage(@PathVariable String user_name) throws SQLException {
		UserDB user = (UserDB)userRepository.findByNickname(user_name).get(0);
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

	@GetMapping("/deleteUserReviews")
	public ModelAndView deleteUserReviews(@PathVariable String nickname, Model model) {
		UserDB user = (UserDB)userRepository.findByNickname(nickname).get(0);
		List<ReviewDB> reviews = reviewRepository.findByUserRef(user);

		for(int i = 0; i<reviews.size();i++) {
			reviewRepository.delete(reviews.get(i));
		}

		user.setReviews(new ArrayList<>());
		userRepository.save(user);

		return new ModelAndView("redirect:/home");
	}
}
