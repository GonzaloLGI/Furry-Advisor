package com.example.demo.Controladores;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.hibernate.engine.jdbc.BlobProxy;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entidades.CommentDB;
import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Interfaces.CommentDBInterface;
import com.example.demo.Interfaces.DealDBInterface;
import com.example.demo.Interfaces.PlaceDBInterface;
import com.example.demo.Interfaces.ReviewDBInterface;
import com.example.demo.Interfaces.UserDBInterface;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML Home
//y de inicializar las entidades ejemplo usadas en la aplicación web
@Controller
public class HomeController {

	private static final Path IMAGES_FOLDER = Paths.get(System.getProperty("user.dir"),"images");
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
	public void init() throws ParseException, IOException, URISyntaxException {
		
		UserDB use1 = new UserDB("xxVicente69xx","sasageyo","manitas@gmail.com",null);
		UserDB use2 = new UserDB("Javier","tierrasanta","h0iboy@hotmail.com",null);
		UserDB use3 = new UserDB("Vico420","blockchain","c.ham.pion@outlook.com",null);
		UserDB use4 = new UserDB("Javapor","asia","vaperwave@hotmail.com",null);
		UserDB use5 = new UserDB("CMarrano","huevoscocidos","sunday_girl@gmail.com",null);
		UserDB use6 = new UserDB("LoboCastellano","brumbrum","motorstormer@gmail.com",null);
		
		PlaceDB pla1 = new PlaceDB("Panda Ramen","Restaurante","Mostoles",null,null,3,"C/Don Juan",null);
		PlaceDB pla2 = new PlaceDB("Simba's Breakfast","Restaurante","Badajoz",null,null,4,"C/Recuerdo",null);
		PlaceDB pla3 = new PlaceDB("Escupe el Fuego","Restaurante","Oviedo",null,null,1,"C/Hincada",null);
		PlaceDB pla4 = new PlaceDB("La Pelusa","Bar","Castellon",null,null,5,"C/Margarina",null);
		PlaceDB pla5 = new PlaceDB("Foxxes Bar","Bar","Madrid",null,null,3,"C/Carrera",null);
		PlaceDB pla6 = new PlaceDB("Pelusa Picarona","Club","Valladolid",null,null,4,"C/Me Falta Un Tornillo",null);
		PlaceDB pla7 = new PlaceDB("Parque Aguadulce","Parque","Albacete",null,null,2,"C/Severo Ochoa",null);
		
		DealDB deal1 = new DealDB("Comisiones abiertas",null,null,pla2);
		DealDB deal2 = new DealDB("10% en ramen",null,null,pla1);
		DealDB deal3 = new DealDB("2x1 en chupitos de absenta",null,null,pla6);
		DealDB deal4 = new DealDB("Galletas con nata gratis",null,null,pla3);
		DealDB deal5 = new DealDB("Reunion en Parque Aguadulce",null,null,pla7);
		
		String txt1 = "El lugar no esta bien. No ofrecen lo que dicen";
		Date dtR1 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01");
		ReviewDB rev1 = new ReviewDB(2,txt1,dtR1,47,use5,pla3);
		String txt2 = "Ramen asqueroso";
		Date dtR2 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-26");
		ReviewDB rev2 = new ReviewDB(1,txt2,dtR2,96,use3,pla1);
		String txt3 = "El mejor día de mi vida <3";
		Date dtR3 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-14");
		ReviewDB rev3 = new ReviewDB(5,txt3,dtR3,24,use1,pla7);
		String txt4 = "RECOMENDADISIMO!!";
		Date dtR4 = new SimpleDateFormat("yyyy-MM-dd").parse("2014-04-20");
		ReviewDB rev4 = new ReviewDB(4,txt4,dtR4,5,use6,pla5);
		
		
		Date dtC1 = new SimpleDateFormat("yyyy-MM-dd").parse("2015-06-25");
		CommentDB comm1 = new CommentDB(dtC1,null,0,use5,rev2);
		Date dtC2 = new SimpleDateFormat("yyyy-MM-dd").parse("2011-10-13");
		CommentDB comm2 = new CommentDB(dtC2,null,0,use2,rev4);
		Date dtC3 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-09");
		CommentDB comm3 = new CommentDB(dtC3,null,0,use3,rev3);	
	
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
		
		Path imagePath1 = IMAGES_FOLDER.resolve("perfil1.jpg");
		File img1 = new File(imagePath1.toUri());
		FileInputStream input1 = new FileInputStream(img1);
		use1.setProf_photo(BlobProxy.generateProxy(input1, Files.size(imagePath1)));
		userRepository.save(use1);
		Path imagePath2 = IMAGES_FOLDER.resolve("unknown.jpg");
		File img2 = new File(imagePath2.toUri());
		FileInputStream input2 = new FileInputStream(img2);
		use2.setProf_photo(BlobProxy.generateProxy(input2, Files.size(imagePath2)));
		userRepository.save(use2);
		File img3 = new File(imagePath2.toUri());
		FileInputStream input3 = new FileInputStream(img3);
		use3.setProf_photo(BlobProxy.generateProxy(input3, Files.size(imagePath2)));
		userRepository.save(use3);
		File img4 = new File(imagePath2.toUri());
		FileInputStream input4 = new FileInputStream(img4);
		use4.setProf_photo(BlobProxy.generateProxy(input4, Files.size(imagePath2)));
		userRepository.save(use4);
		File img5 = new File(imagePath2.toUri());
		FileInputStream input5 = new FileInputStream(img5);
		use5.setProf_photo(BlobProxy.generateProxy(input5, Files.size(imagePath2)));
		userRepository.save(use5);
		File img6 = new File(imagePath2.toUri());
		FileInputStream input6 = new FileInputStream(img6);
		use6.setProf_photo(BlobProxy.generateProxy(input6, Files.size(imagePath2)));
		userRepository.save(use6);
		
		Path imagePath3 = IMAGES_FOLDER.resolve("restaurante.jpg");
		File img7 = new File(imagePath3.toUri());
		FileInputStream input7 = new FileInputStream(img7);
		pla1.setPlacePic(BlobProxy.generateProxy(input7, Files.size(imagePath3)));
		placeRepository.save(pla1);
		File img8 = new File(imagePath3.toUri());
		FileInputStream input8 = new FileInputStream(img8);
		pla2.setPlacePic(BlobProxy.generateProxy(input8, Files.size(imagePath3)));
		placeRepository.save(pla2);
		File img9 = new File(imagePath3.toUri());
		FileInputStream input9 = new FileInputStream(img9);
		pla3.setPlacePic(BlobProxy.generateProxy(input9, Files.size(imagePath3)));
		placeRepository.save(pla3);
		File img10 = new File(imagePath3.toUri());
		FileInputStream input10 = new FileInputStream(img10);
		pla4.setPlacePic(BlobProxy.generateProxy(input10, Files.size(imagePath3)));
		placeRepository.save(pla4);
		File img11 = new File(imagePath3.toUri());
		FileInputStream input11 = new FileInputStream(img11);
		pla5.setPlacePic(BlobProxy.generateProxy(input11, Files.size(imagePath3)));
		placeRepository.save(pla5);
		File img12 = new File(imagePath3.toUri());
		FileInputStream input12 = new FileInputStream(img12);
		pla6.setPlacePic(BlobProxy.generateProxy(input12, Files.size(imagePath3)));
		placeRepository.save(pla6);
		File img13 = new File(imagePath3.toUri());
		FileInputStream input13 = new FileInputStream(img13);
		pla7.setPlacePic(BlobProxy.generateProxy(input13, Files.size(imagePath3)));
		placeRepository.save(pla7);
		
		Path imagePath4 = IMAGES_FOLDER.resolve("oferta2.jpg");
		File img14 = new File(imagePath4.toUri());
		FileInputStream input14 = new FileInputStream(img14);
		deal1.setDealPic(BlobProxy.generateProxy(input14, Files.size(imagePath4)));
		dealRepository.save(deal1);
		File img15 = new File(imagePath4.toUri());
		FileInputStream input15 = new FileInputStream(img15);
		deal2.setDealPic(BlobProxy.generateProxy(input15, Files.size(imagePath4)));
		dealRepository.save(deal2);
		File img16 = new File(imagePath4.toUri());
		FileInputStream input16 = new FileInputStream(img16);
		deal3.setDealPic(BlobProxy.generateProxy(input16, Files.size(imagePath4)));
		dealRepository.save(deal3);
		File img17 = new File(imagePath4.toUri());
		FileInputStream input17 = new FileInputStream(img17);
		deal4.setDealPic(BlobProxy.generateProxy(input17, Files.size(imagePath4)));
		dealRepository.save(deal4);
		File img18 = new File(imagePath4.toUri());
		FileInputStream input18 = new FileInputStream(img18);
		deal5.setDealPic(BlobProxy.generateProxy(input18, Files.size(imagePath4)));
		dealRepository.save(deal5);
	}


	@GetMapping("/home")
	public String home(Model model) {

		List<DealDB> deals = dealRepository.findAllByPlaceOriginIsNotNull();
		DealDB dealDB1 = deals.get(0);
		DealDB dealDB2 = deals.get(2);
		
		
		model.addAttribute("place_name1", dealDB1.getPlaceOrigin().getName());
		model.addAttribute("place_name2", dealDB2.getPlaceOrigin().getName());
		model.addAttribute("deal_image1", dealDB1.getDealPic());
		model.addAttribute("deal_image2", dealDB2.getDealPic());
		model.addAttribute("deal_header1", dealDB1.getHeader());
		model.addAttribute("deal_header2", dealDB2.getHeader());
		return "home";
	}
	
	@GetMapping("/perfil")
	public ResponseEntity<Object> perfil(HttpSession http, Model model) throws MalformedURLException, SQLException {
		List<DealDB> deals = dealRepository.findAllByPlaceOriginIsNotNull();
		DealDB dealDB1 = deals.get(0);
		//DealDB dealDB2 = deals.get(2);
		
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
}
