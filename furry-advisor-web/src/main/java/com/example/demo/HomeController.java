package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

	
	@Autowired
	private PlaceDBInterface placeRepository;
	@Autowired
	private UserDBInterface userRepository;

	@PostConstruct
	public void init() {
		placeRepository.save(new PlaceDB(1,"Panda Ramen","Restaurante",3,"C/Don Juan"));
		placeRepository.save(new PlaceDB(2,"Simba's Breakfast","Restaurante",4,"C/Recuerdo"));
		placeRepository.save(new PlaceDB(3,"Escupe el Fuego","Restaurante",1,"C/Hincada"));
		placeRepository.save(new PlaceDB(4,"La Pelusa","Bar",5,"C/Margarina"));
		placeRepository.save(new PlaceDB(5,"Foxxes Bar","Bar",3,"C/Carrera"));
		placeRepository.save(new PlaceDB(6,"Pelusa Picarona","Club",4,"C/Me Falta Un Tornillo"));
		placeRepository.save(new PlaceDB(7,"Parque Aguadulce","Parque",2,"C/Severo Ochoa"));
		
		userRepository.save(new UserDB(1,"xxVicente69xx","sasageyo"));
		userRepository.save(new UserDB(2,"Javier","tierrasanta"));
		userRepository.save(new UserDB(3,"Vico420","blockchain"));
		userRepository.save(new UserDB(4,"Javapor","asia"));
		userRepository.save(new UserDB(5,"CMarrano","huevoscocidos"));
		userRepository.save(new UserDB(6,"LoboCastellano","brumbrum"));
	}
}
