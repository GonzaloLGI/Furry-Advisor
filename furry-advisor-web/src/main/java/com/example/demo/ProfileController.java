package com.example.demo;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
public class ProfileController implements CommandLineRunner {
	
	private static final Path IMAGES_FOLDER = Paths.get(System.getProperty("user.dir"),"images");
	@Autowired
	private UserDBInterface userRepository;
	@Autowired 
	private PlaceDBInterface placeRepository;

	@PostMapping("/profile")
	public String profile(Model model, @RequestParam String userName, @RequestParam String userPassword) {
	 
		//testDB(userName,userPassword);
		
		model.addAttribute("name", userName);
		model.addAttribute("password",userPassword);
		
		userRepository.save(new UserDB(2,userName,userPassword));
		List<UserDB> user = userRepository.findByNickname("Manuel");
		System.out.println(user.get(0).getPassword());
		
		List<PlaceDB> places = placeRepository.findAll();
		model.addAttribute("n1",places.get(0).getName());
		model.addAttribute("t1",places.get(0).getType());
		model.addAttribute("v1",places.get(0).getScore());
		
		return "userPage";
	}
	
	@PostMapping("/upload_image")
	public String uploadImage(@RequestParam MultipartFile image) throws IOException {
		Files.createDirectories(IMAGES_FOLDER);
		Path imagePath = IMAGES_FOLDER.resolve("perfil.jpg");
		image.transferTo(imagePath);
		return "userPage";
	}	
	
	@GetMapping("/perfil")
	public ResponseEntity<Object> downloadImage(Model model) throws MalformedURLException {
		Path imagePath = IMAGES_FOLDER.resolve("perfil.jpg");
		Resource image = new UrlResource(imagePath.toUri());
		return ResponseEntity.ok()
		.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
		.body(image);
	}
	
	//La pagina de login y de register son distintas, luego hacer 2 htmls y 2 controladores por separado
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		testDB("Vicente","pasion");
		
	}
	
	public void testDB(String userName, String userPassword) {
		placeRepository.save(new PlaceDB(1,"Panda Ramen","Restaurante",3));
		placeRepository.save(new PlaceDB(2,"La Pelusa","Bar",5));
		
		userRepository.save(new UserDB(1,userName,userPassword));
		
		
		List<PlaceDB> place = placeRepository.findByName("La Pelusa");
		System.out.println(place.get(0).getType());
	}

}
