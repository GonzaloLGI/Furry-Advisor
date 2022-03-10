package com.example.demo.Controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.example.demo.Services.ReviewService;
import com.example.demo.Services.UserService;

//Clase que se encarga de gestionar las periciones hacia Registe/Sign Up
@Controller
public class RegisterController {
	
	private static final Path IMAGES_FOLDER = Paths.get(System.getProperty("user.dir"),"images");
	
	@Autowired
	private UserService userRepository;

	@GetMapping("/createProfile")
	public String profile(HttpSession http, Model model, @RequestParam String userName, @RequestParam String userPassword) throws IOException {
	 
		List<UserDB> userAux = userRepository.findByNickname(userName);
		
		if(!userAux.isEmpty()) {
			System.out.println("Este usuario ya existe");
			return "login";
		}
		else {
		
				PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
				String newPassword = encoder.encode(userPassword);
				UserDB newUser = new UserDB(userName,newPassword,null,null,"ROLE_USER");
				http.setAttribute("actUser", newUser);
				userRepository.save(newUser);
				
				model.addAttribute("name", userName);
				model.addAttribute("password",userPassword);
				
				Path imagePathReg = IMAGES_FOLDER.resolve("unknown.jpg");
				File imgReg = new File(imagePathReg.toUri());
				FileInputStream input2 = new FileInputStream(imgReg);
				newUser.setProf_photo(BlobProxy.generateProxy(input2, Files.size(imagePathReg)));
				http.setAttribute("actUser", newUser);
				userRepository.save(newUser);
		
				return "profile/"+userName;
			
		}
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		return "register";
	}
}
