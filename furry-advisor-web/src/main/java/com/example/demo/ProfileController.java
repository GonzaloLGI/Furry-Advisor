package com.example.demo;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

@Controller
public class ProfileController {
	
	private static final Path IMAGES_FOLDER = Paths.get(System.getProperty("user.dir"),"images");

	@PostMapping("/profile")
	public String profile(Model model, @RequestParam String userName, @RequestParam String userPassword) {
	 
		model.addAttribute("name", userName);
		model.addAttribute("password",userPassword);
		return "userPage";
	}
	
	@PostMapping("/upload_image")
	public String uploadImage(@RequestParam MultipartFile image) throws IOException {
		Files.createDirectories(IMAGES_FOLDER);
		Path imagePath = IMAGES_FOLDER.resolve("perfil.jpg");
		image.transferTo(imagePath);
		return "profile";
	}	
	
	@GetMapping("/perfil")
	public ResponseEntity<Object> downloadImage(Model model) throws MalformedURLException {
		Path imagePath = IMAGES_FOLDER.resolve("perfil.jpg");
		Resource image = new UrlResource(imagePath.toUri());
		return ResponseEntity.ok()
		.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
		.body(image);
		}

}
