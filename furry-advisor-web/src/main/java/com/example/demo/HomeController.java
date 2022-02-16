package com.example.demo;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

	
	@Autowired
	private PlaceDBInterface placeRepository;
	@Autowired
	private UserDBInterface userRepository;
	@Autowired
	private CommentDBInterface commentRepository;
	@Autowired
	private DealDBInterface dealRepository;
	@Autowired
	private ReviewDBInterface reviewRepository;

	@PostConstruct
	public void init() throws ParseException {
		
		UserDB use1 = new UserDB(1,"xxVicente69xx","sasageyo");
		UserDB use2 = new UserDB(2,"Javier","tierrasanta");
		UserDB use3 = new UserDB(3,"Vico420","blockchain");
		UserDB use4 = new UserDB(4,"Javapor","asia");
		UserDB use5 = new UserDB(5,"CMarrano","huevoscocidos");
		UserDB use6 = new UserDB(6,"LoboCastellano","brumbrum");
		
		PlaceDB pla1 = new PlaceDB(7,"Panda Ramen","Restaurante",3,"C/Don Juan");
		PlaceDB pla2 = new PlaceDB(8,"Simba's Breakfast","Restaurante",4,"C/Recuerdo");
		PlaceDB pla3 = new PlaceDB(9,"Escupe el Fuego","Restaurante",1,"C/Hincada");
		PlaceDB pla4 = new PlaceDB(10,"La Pelusa","Bar",5,"C/Margarina");
		PlaceDB pla5 = new PlaceDB(11,"Foxxes Bar","Bar",3,"C/Carrera");
		PlaceDB pla6 = new PlaceDB(12,"Pelusa Picarona","Club",4,"C/Me Falta Un Tornillo");
		PlaceDB pla7 = new PlaceDB(13,"Parque Aguadulce","Parque",2,"C/Severo Ochoa");
		
		DealDB deal1 = new DealDB(14,"Comisiones abiertas",pla2);
		DealDB deal2 = new DealDB(15,"10% en ramen",pla1);
		DealDB deal3 = new DealDB(16,"2x1 en chupitos de absenta",pla6);
		DealDB deal4 = new DealDB(17,"Galletas con nata gratis",pla3);
		DealDB deal5 = new DealDB(18,"Reunion en Parque Aguadulce",pla7);
		
		//Hay un problema de bucle entre comment, user y review
		
		String txt1 = "El lugar no esta bien. No ofrecen lo que dicen";
		Date dtR1 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01");
		ReviewDB rev1 = new ReviewDB(19,2,txt1,dtR1,47,use5,pla3);
		String txt2 = "Ramen asqueroso";
		Date dtR2 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-26");
		ReviewDB rev2 = new ReviewDB(20,1,txt2,dtR2,96,use3,pla1);
		String txt3 = "El mejor día de mi vida <3";
		Date dtR3 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-14");
		ReviewDB rev3 = new ReviewDB(21,5,txt3,dtR3,24,use1,pla7);
		String txt4 = "RECOMENDADISIMO!!";
		Date dtR4 = new SimpleDateFormat("yyyy-MM-dd").parse("2014-04-20");
		ReviewDB rev4 = new ReviewDB(22,4,txt4,dtR4,5,use6,pla5);
		
		
		Date dtC1 = new SimpleDateFormat("yyyy-MM-dd").parse("2015-06-25");
		CommentDB comm1 = new CommentDB(23,dtC1,use5,rev2);
		Date dtC2 = new SimpleDateFormat("yyyy-MM-dd").parse("2011-10-13");
		CommentDB comm2 = new CommentDB(24,dtC2,use2,rev4);
		Date dtC3 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-09");
		CommentDB comm3 = new CommentDB(25,dtC3,use3,rev3);	
		
		userRepository.save(use1);
		userRepository.save(use2);
		userRepository.save(use3);
		userRepository.save(use4);
		userRepository.save(use5);
		userRepository.save(use6);
		
		placeRepository.save(pla1);
		placeRepository.save(pla2);
		placeRepository.save(pla3);
		placeRepository.save(pla4);
		placeRepository.save(pla5);
		placeRepository.save(pla6);
		placeRepository.save(pla7);
		
		dealRepository.save(deal1);
		dealRepository.save(deal2);
		dealRepository.save(deal3);
		dealRepository.save(deal4);
		dealRepository.save(deal5);
		
		reviewRepository.save(rev1);
		reviewRepository.save(rev2);
		reviewRepository.save(rev3);
		reviewRepository.save(rev4);
		
		commentRepository.save(comm1);
		commentRepository.save(comm2);
		commentRepository.save(comm3);
		
		
		
		//El problema esta en que, como es cascada, cuando se guarda el padre se guarda el objeto ajeno
		
	}
}
