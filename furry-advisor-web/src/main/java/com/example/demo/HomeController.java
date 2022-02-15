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
		
		//Hay un problema de bucle entre comment, user y review
		List<CommentDB> comms1 = new ArrayList<CommentDB>();
		List<CommentDB> comms2 = new ArrayList<CommentDB>();
		List<CommentDB> comms3 = new ArrayList<CommentDB>();
		List<CommentDB> comms4 = new ArrayList<CommentDB>();
		
		String txt1 = "El lugar no esta bien. No ofrecen lo que dicen";
		Date dtR1 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01");
		ReviewDB rev1 = new ReviewDB(1,2,txt1,dtR1,47,comms1);
		String txt2 = "Ramen asqueroso";
		Date dtR2 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-26");
		ReviewDB rev2 = new ReviewDB(2,1,txt2,dtR2,96,comms2);
		String txt3 = "El mejor día de mi vida <3";
		Date dtR3 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-14");
		ReviewDB rev3 = new ReviewDB(3,5,txt3,dtR3,24,comms3);
		String txt4 = "RECOMENDADISIMO!!";
		Date dtR4 = new SimpleDateFormat("yyyy-MM-dd").parse("2014-04-20");
		ReviewDB rev4 = new ReviewDB(4,4,txt4,dtR4,5,comms4);
		
		List<ReviewDB> revsUs1 = new ArrayList<ReviewDB>();
		List<ReviewDB> revsUs2 = new ArrayList<ReviewDB>();
		List<ReviewDB> revsUs3 = new ArrayList<ReviewDB>();
		List<ReviewDB> revsUs4 = new ArrayList<ReviewDB>();
		List<ReviewDB> revsUs5 = new ArrayList<ReviewDB>();
		List<ReviewDB> revsUs6 = new ArrayList<ReviewDB>();
		/*revsUs1.add(rev1);
		revsUs2.add(rev2);
		revsUs3.add(rev3);
		revsUs4.add(rev4);*/
		
		UserDB use1 = new UserDB(1,"xxVicente69xx","sasageyo",revsUs1);
		UserDB use2 = new UserDB(2,"Javier","tierrasanta",revsUs2);
		UserDB use3 = new UserDB(3,"Vico420","blockchain",revsUs3);
		UserDB use4 = new UserDB(4,"Javapor","asia",revsUs4);
		UserDB use5 = new UserDB(5,"CMarrano","huevoscocidos",revsUs5);
		UserDB use6 = new UserDB(6,"LoboCastellano","brumbrum",revsUs6);
		
		Date dtC1 = new SimpleDateFormat("yyyy-MM-dd").parse("2015-06-25");
		CommentDB comm1 = new CommentDB(1,dtC1,use3);
		Date dtC2 = new SimpleDateFormat("yyyy-MM-dd").parse("2011-10-13");
		CommentDB comm2 = new CommentDB(2,dtC2,use5);
		Date dtC3 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-09");
		CommentDB comm3 = new CommentDB(3,dtC3,use4);	
		
		comms3.add(comm3);
		comms2.add(comm2);
		rev2.setComments(comms2);
		rev3.setComments(comms3);
		
		DealDB deal1 = new DealDB(1,"Comisiones abiertas");
		DealDB deal2 = new DealDB(2,"10% en ramen");
		DealDB deal3 = new DealDB(3,"2x1 en chupitos de absenta");
		DealDB deal4 = new DealDB(4,"Galletas con nata gratis");
		DealDB deal5 = new DealDB(5,"Reunion en Parque Aguadulce");
		
		List<DealDB> deals1 = new ArrayList<DealDB>();
		List<DealDB> deals2 = new ArrayList<DealDB>();
		List<DealDB> deals3 = new ArrayList<DealDB>();
		List<DealDB> deals4 = new ArrayList<DealDB>();
		List<DealDB> deals5 = new ArrayList<DealDB>();
		List<DealDB> deals6 = new ArrayList<DealDB>();
		List<DealDB> deals7 = new ArrayList<DealDB>();
		deals2.add(deal1);
		deals2.add(deal3);
		deals2.add(deal5);
		deals4.add(deal2);
		deals4.add(deal4);
		
		List<ReviewDB> revsPl1 = new ArrayList<ReviewDB>();
		List<ReviewDB> revsPl2 = new ArrayList<ReviewDB>();
		List<ReviewDB> revsPl3 = new ArrayList<ReviewDB>();
		List<ReviewDB> revsPl4 = new ArrayList<ReviewDB>();
		List<ReviewDB> revsPl5 = new ArrayList<ReviewDB>();
		List<ReviewDB> revsPl6 = new ArrayList<ReviewDB>();
		List<ReviewDB> revsPl7 = new ArrayList<ReviewDB>();
		revsPl2.add(rev3);
		revsPl5.add(rev2);
		revsPl3.add(rev4);
		revsPl7.add(rev1);
		
		
		PlaceDB pla1 = new PlaceDB(1,"Panda Ramen","Restaurante",3,"C/Don Juan",deals1,revsPl1);
		PlaceDB pla2 = new PlaceDB(2,"Simba's Breakfast","Restaurante",4,"C/Recuerdo",deals2,revsPl2);
		PlaceDB pla3 = new PlaceDB(3,"Escupe el Fuego","Restaurante",1,"C/Hincada",deals3,revsPl3);
		PlaceDB pla4 = new PlaceDB(4,"La Pelusa","Bar",5,"C/Margarina",deals4,revsPl4);
		PlaceDB pla5 = new PlaceDB(5,"Foxxes Bar","Bar",3,"C/Carrera",deals5,revsPl5);
		PlaceDB pla6 = new PlaceDB(6,"Pelusa Picarona","Club",4,"C/Me Falta Un Tornillo",deals6,revsPl6);
		PlaceDB pla7 = new PlaceDB(7,"Parque Aguadulce","Parque",2,"C/Severo Ochoa",deals7,revsPl7);	
		
		dealRepository.save(deal1);
		dealRepository.save(deal2);
		dealRepository.save(deal3);
		dealRepository.save(deal4);
		dealRepository.save(deal5);
		
		//reviewRepository.save(rev1);
		//reviewRepository.save(rev2);
		//reviewRepository.save(rev3);
		//reviewRepository.save(rev4);
		
		placeRepository.save(pla1);
		placeRepository.save(pla2);
		placeRepository.save(pla3);
		placeRepository.save(pla4);
		placeRepository.save(pla5);
		placeRepository.save(pla6);
		placeRepository.save(pla7);
		
		//El problema esta en que, como es cascada, cuando se guarda el padre se guarda el objeto ajeno
		userRepository.save(use1);
		userRepository.save(use2);
		//userRepository.save(use3);
		//userRepository.save(use4);
		//userRepository.save(use5);
		userRepository.save(use6);
		
		commentRepository.save(comm1);
		/*commentRepository.save(comm2);
		commentRepository.save(comm3);*/
		
		
	}
}
