package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class SearchController implements CommandLineRunner {
	@Autowired
	private PlaceDBInterface placeRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<PlaceDB> places = placeRepository.findByType("Club");
		System.out.println(places.get(0).getRating());
	}
	
	
	
}
