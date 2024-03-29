package com.example.demo.Controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.engine.jdbc.BlobProxy;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.ImageUtils;
import com.example.demo.NewOffer;
import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.DealDBJson;
import com.example.demo.Entidades.LocationDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.PlaceTypeDB;
import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Services.DealService;
import com.example.demo.Services.LocationService;
import com.example.demo.Services.PlaceService;
import com.example.demo.Services.PlaceTypeService;
import com.example.demo.Services.ReviewService;
import com.example.demo.Services.UserService;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.hazelcast.com.google.common.base.Charsets;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML Home
//y de inicializar las entidades ejemplo usadas en la aplicación web

@EnableScheduling
@Controller
public class HomeController {

	public static int dealCuantity;
	
	@Autowired
	public NewOffer newOffer;
	
	@Autowired
	private UserComponent component;
	
	@Autowired
	private PlaceService placeRepository;
	
	@Autowired
	private PlaceTypeService placeTypeRepository;
	
	@Autowired
	private LocationService locationRepository;
	
	@Autowired
	private UserService userRepository;
	
	@Autowired
	private DealService dealRepository;
	
	@Autowired
	private ReviewService reviewRepository;

	@Value("${internalService.baseUri}")
	private String intServiceURI;

	@PostConstruct
	public void init() throws ParseException, IOException, URISyntaxException {
		
		//dealRepository.delete(dealRepository.findByHeader("cabecera").get(0));
		//El problema era que no se usaba el mismo objeto para hacer hash (BCryptPasswordEncoder vs PasswordEncoder)
		if(userRepository.findAll().size()==0) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String pass1 = encoder.encode("sasageyo");
			String pass2 = encoder.encode("tierrasanta");
			String pass3 = encoder.encode("blockchain");
			String pass4 = encoder.encode("asia");
			String pass5 = encoder.encode("huevoscocidos");
			String pass6 = encoder.encode("brumbrum");
			
			UserDB use1 = new UserDB("xxVicente69xx",pass1,"manitas@gmail.com",null,"ROLE_ADMIN");
			UserDB use2 = new UserDB("Javier",pass2,"h0iboy@hotmail.com",null,"ROLE_USER");
			UserDB use3 = new UserDB("Vico420",pass3,"c.ham.pion@outlook.com",null,"ROLE_USER");
			UserDB use4 = new UserDB("Javapor",pass4,"vaperwave@hotmail.com",null,"ROLE_USER");
			UserDB use5 = new UserDB("CMarrano",pass5,"sunday_girl@gmail.com",null,"ROLE_USER");
			UserDB use6 = new UserDB("LoboCastellano",pass6,"motorstormer@gmail.com",null,"ROLE_USER");
			
			LocationDB loc1 = new LocationDB("Mostoles");
			LocationDB loc2 = new LocationDB("Badajoz");
			LocationDB loc3 = new LocationDB("Oviedo");
			LocationDB loc4 = new LocationDB("Castellon");
			LocationDB loc5 = new LocationDB("Madrid");
			LocationDB loc6 = new LocationDB("Valladolid");
			LocationDB loc7 = new LocationDB("Albacete");
			
			PlaceTypeDB type1 = new PlaceTypeDB("Restaurante");
			PlaceTypeDB type2 = new PlaceTypeDB("Bar");
			PlaceTypeDB type3 = new PlaceTypeDB("Club");
			PlaceTypeDB type4 = new PlaceTypeDB("Parque");
			
			PlaceDB pla1 = new PlaceDB("Panda Ramen",type1,loc1,"Descripcion1","URL1",3,"C/Don Juan","Schedule1",null);
			PlaceDB pla2 = new PlaceDB("Simba's Breakfast",type1,loc2,"Descripcion2","URL2",4,"C/Recuerdo","Schedule2",null);
			PlaceDB pla3 = new PlaceDB("Escupe el Fuego",type1,loc3,"Descripcion3","URL3",1,"C/Hincada","Schedule3",null);
			PlaceDB pla4 = new PlaceDB("La Pelusa",type2,loc4,"Descripcion4","URL4",5,"C/Margarina","Schedule4",null);
			PlaceDB pla5 = new PlaceDB("Foxxes Bar",type2,loc5,"Descripcion5","URL5",3,"C/Carrera","Schedule5",null);
			PlaceDB pla6 = new PlaceDB("Pelusa Picarona",type3,loc6,"Descripcion6","URL6",4,"C/Me Falta Un Tornillo","Schedule6",null);
			PlaceDB pla7 = new PlaceDB("Parque Aguadulce",type4,loc7,"Descripcion7","URL7",2,"C/Severo Ochoa","Schedule7",null);
			
			DealDB deal1 = new DealDB("Comisiones abiertas","Description1",null,pla2);
			DealDB deal2 = new DealDB("10% en ramen","Description2",null,pla1);
			DealDB deal3 = new DealDB("2x1 en chupitos de absenta","Description3",null,pla6);
			DealDB deal4 = new DealDB("Galletas con nata gratis","Description4",null,pla3);
			DealDB deal5 = new DealDB("Reunion en Parque Aguadulce","Description5",null,pla7);
			
			String txt1 = "El lugar no esta bien. No ofrecen lo que dicen";
			Date dtR1 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01");
			ReviewDB rev1 = new ReviewDB(2,txt1,dtR1,47,use5,pla3);//use5
			String txt2 = "Ramen asqueroso";
			Date dtR2 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-26");
			ReviewDB rev2 = new ReviewDB(1,txt2,dtR2,96,use3,pla1);//use3
			String txt3 = "El mejor día de mi vida <3";
			Date dtR3 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-14");
			ReviewDB rev3 = new ReviewDB(5,txt3,dtR3,24,use1,pla7);//use1
			String txt4 = "RECOMENDADISIMO!!";
			Date dtR4 = new SimpleDateFormat("yyyy-MM-dd").parse("2014-04-20");
			ReviewDB rev4 = new ReviewDB(4,txt4,dtR4,5,use6,pla5);//use6
		
			
			List<ReviewDB> aux6 = new ArrayList<>();
			aux6.add(rev1);
			List<ReviewDB> aux7 = new ArrayList<>();
			aux7.add(rev2);
			List<ReviewDB> aux8 = new ArrayList<>();
			aux8.add(rev3);
			List<ReviewDB> aux9 = new ArrayList<>();
			aux9.add(rev4);
			use5.setReviews(aux6);
			use3.setReviews(aux7);
			use1.setReviews(aux8);
			use6.setReviews(aux9);
			use2.setReviews(new ArrayList<>());
			use4.setReviews(new ArrayList<>());
			
			placeTypeRepository.save(type1);
			placeTypeRepository.save(type2);
			placeTypeRepository.save(type3);
			placeTypeRepository.save(type4);
			
			locationRepository.save(loc1);
			locationRepository.save(loc2);
			locationRepository.save(loc3);
			locationRepository.save(loc4);
			locationRepository.save(loc5);
			locationRepository.save(loc6);
			locationRepository.save(loc7);
			
			
			
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
			
			userRepository.save(use1);
			userRepository.save(use2);
			userRepository.save(use3);
			userRepository.save(use4);
			userRepository.save(use5);
			userRepository.save(use6);
			
			
			String input1 = ImageUtils.imageToString("images/perfil1.jpg");
			String input2 = ImageUtils.imageToString("images/unknown.jpg");
		
		
			use1.setProf_photo(input1);
			userRepository.save(use1);
			use2.setProf_photo(input2);
			userRepository.save(use2);
			use3.setProf_photo(input2);
			userRepository.save(use3);
			use4.setProf_photo(input2);
			userRepository.save(use4);
			use5.setProf_photo(input2);
			userRepository.save(use5);
			use6.setProf_photo(input2);
			userRepository.save(use6);
			
			InputStream input7 = getClass().getClassLoader().getResourceAsStream("images/restaurante.jpg");
			pla1.setPlacePic(BlobProxy.generateProxy(input7, input7.available()));
			placeRepository.save(pla1);
			InputStream input8 = getClass().getClassLoader().getResourceAsStream("images/restaurante.jpg");
			pla2.setPlacePic(BlobProxy.generateProxy(input8, input8.available()));
			placeRepository.save(pla2);
			InputStream input9 = getClass().getClassLoader().getResourceAsStream("images/restaurante.jpg");
			pla3.setPlacePic(BlobProxy.generateProxy(input9, input9.available()));
			placeRepository.save(pla3);
			InputStream input10 = getClass().getClassLoader().getResourceAsStream("images/restaurante.jpg");
			pla4.setPlacePic(BlobProxy.generateProxy(input10, input10.available()));
			placeRepository.save(pla4);
			InputStream input11 = getClass().getClassLoader().getResourceAsStream("images/restaurante.jpg");
			pla5.setPlacePic(BlobProxy.generateProxy(input11, input11.available()));
			placeRepository.save(pla5);
			InputStream input12 = getClass().getClassLoader().getResourceAsStream("images/restaurante.jpg");
			pla6.setPlacePic(BlobProxy.generateProxy(input12, input12.available()));
			placeRepository.save(pla6);
			InputStream input13 = getClass().getClassLoader().getResourceAsStream("images/restaurante.jpg");
			pla7.setPlacePic(BlobProxy.generateProxy(input13, input13.available()));
			placeRepository.save(pla7);
			
			InputStream input14 = getClass().getClassLoader().getResourceAsStream("images/oferta2.jpg");
			deal1.setDealPic(BlobProxy.generateProxy(input14, input14.available()));
			dealRepository.save(deal1);
			InputStream input15 = getClass().getClassLoader().getResourceAsStream("images/oferta2.jpg");
			deal2.setDealPic(BlobProxy.generateProxy(input15, input15.available()));
			dealRepository.save(deal2);
			InputStream input16 = getClass().getClassLoader().getResourceAsStream("images/oferta2.jpg");
			deal3.setDealPic(BlobProxy.generateProxy(input16, input16.available()));
			dealRepository.save(deal3);
			InputStream input17 = getClass().getClassLoader().getResourceAsStream("images/oferta2.jpg");
			deal4.setDealPic(BlobProxy.generateProxy(input17,input17.available()));
			dealRepository.save(deal4);
			InputStream input18 = getClass().getClassLoader().getResourceAsStream("images/oferta2.jpg");
			deal5.setDealPic(BlobProxy.generateProxy(input18, input18.available()));
			dealRepository.save(deal5);
		}
	}


	@GetMapping("/home")
	public String home(Model model,HttpSession http) {
		UserDB actualUser = component.getLoggedUser();
		model.addAttribute("user",actualUser);
		List<DealDB> deals = dealRepository.findAllByPlaceOriginIsNotNull();
		
		int max = deals.size();
		int min = 0;
		int dl1 = (int) (Math.random() * (max - min - 1) + min);
		DealDB dealDB1 = deals.get(dl1);
		int dl2 = (int) (Math.random() * (max - min - 1) + min);
		while(dl1==dl2) {
			dl2 = (int) (Math.random() * (max - min - 1) + min);
		}
		DealDB dealDB2 = deals.get(dl2);

		model.addAttribute("newoffer",newOffer.getNewOffer());
		model.addAttribute("place_name1", dealDB1.getPlaceOrigin().getName());
		model.addAttribute("place_name2", dealDB2.getPlaceOrigin().getName());
		model.addAttribute("deal_image1", dealDB1.getDealPic());
		model.addAttribute("deal_image2", dealDB2.getDealPic());
		model.addAttribute("deal_header1", dealDB1.getHeader());
		model.addAttribute("deal_header2", dealDB2.getHeader());
		
		List<PlaceDB> places = placeRepository.findAll();

        int maxPlace = places.size();
        int minPlace = 0;
        int pl1=(int)Math.random()*(maxPlace - minPlace - 1) + minPlace;
        int pl2=(int)Math.random()*(maxPlace - minPlace - 1) + minPlace;
        PlaceDB place3 = places.get(pl1);
        PlaceDB place4 = places.get(pl2);
        model.addAttribute("place_name3",place3.getName());
        model.addAttribute("place_horario1",place3.getSchedule());
        model.addAttribute("place_bio1",place3.getDescription());
        model.addAttribute("place_name4",place4.getName());
        model.addAttribute("place_horario2",place4.getSchedule());
        model.addAttribute("place_bio2",place4.getDescription());
        model.addAttribute("place",dealDB1.getPlaceOrigin().getName());
        model.addAttribute("offer",dealDB1.getHeader());
        
        http.setAttribute("place", dealDB1.getPlaceOrigin().getName());
        http.setAttribute("offer", dealDB1.getHeader());
		
		return "home";
	}
	
	@GetMapping("/perfil")
	public ResponseEntity<Object> perfil(Model model) throws MalformedURLException, SQLException {
		List<DealDB> deals = dealRepository.findAllByPlaceOriginIsNotNull();
		int maxPlace = deals.size();
        int minPlace = 0;
        int pl1=(int)Math.random()*(maxPlace - minPlace - 1) + minPlace;
		DealDB dealDB1 = deals.get(pl1);
		
		if (dealDB1.getDealPic() != null) {
			Resource image = new InputStreamResource(dealDB1.getDealPic().getBinaryStream());
			return ResponseEntity.ok()
					 .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
					 .contentLength(dealDB1.getDealPic().length())
					 .body(image);
		}else {
			System.out.println("No hay foto");
			return  ResponseEntity.notFound().build();
		}
		
	}

	@Scheduled(fixedRate=20000)
	@GetMapping("/checkRest")
	public ModelAndView checkRest() {
		RestTemplate rest = new RestTemplate();
		String base = intServiceURI;
		String url = base+"/deals";
		//DEVUELVE ARRAYNODE, NO OBJECTNODE. ESOS ESTAN DENTRO
		ArrayNode data = rest.getForObject(url, ArrayNode.class);

		if(data == null){
			return new ModelAndView("redirect:/home");
		}

		int newDealCuantity = data.size();

		for(int i = 0; i<data.size();i++) {
			System.out.println(data.get(i).get("header").asText());
		}

		if(newDealCuantity > dealCuantity){
			dealCuantity = newDealCuantity;
			System.out.println("Hay nuevas ofertas");

			newOffer.setNewOffer(true);
		}
		else{
			System.out.println("No hay nueva ofertas");

			newOffer.setNewOffer(false);
		}
		return new ModelAndView("redirect:/home");
	}
	
	@PostMapping("/addNewDeal/{place_name}")
	public ModelAndView addNewDeal(Model model,HttpSession http, @RequestParam String header, @RequestParam String description, @PathVariable String place_name) throws URISyntaxException, IOException, SerialException, SQLException {
		RestTemplate rest = new RestTemplate();
		DealDBJson newDeal = new DealDBJson(header,description,place_name);
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<DealDBJson> entity = new HttpEntity<>(newDeal,headers);
		String base = intServiceURI;
		String url = base+"/deals";
		URI uri = new URI(url);
		rest.postForEntity(uri, entity,DealDBJson.class);
		
	    model.addAttribute("place",http.getAttribute("place"));
	    model.addAttribute("offer",http.getAttribute("offer"));
		System.out.println("Subido");
		return new ModelAndView("redirect:/home");
	}

	
}
