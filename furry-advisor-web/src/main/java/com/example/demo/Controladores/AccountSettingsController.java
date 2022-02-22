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

import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Interfaces.PlaceDBInterface;
import com.example.demo.Interfaces.ReviewDBInterface;
import com.example.demo.Interfaces.UserDBInterface;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML edit_profile
@Controller
public class AccountSettingsController implements CommandLineRunner {
	
	
	@Autowired
	private UserDBInterface userRepository;
	
	
	@PostMapping("/account_settings")
	public String account_settings(HttpSession http, Model model, @RequestParam String userName, @RequestParam String newPassword) {
	 
		
		UserDB actualUser = userRepository.findByNickname(userName).get(0);
			
		http.setAttribute("actUser", actualUser);//GONZALO EXPLICA ESTO
				
		if(!newPassword.equals("")) {
			actualUser.setPassword(newPassword);
		}
			
		return "account_settings";
			
		
	}
	
}
