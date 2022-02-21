package com.example.demo.Controladores;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Interfaces.ReviewDBInterface;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML Login
@Controller
public class LoginController {
	 private Logger log = (Logger) LoggerFactory.getLogger(LoginController.class);
	 
	 @Autowired
	 private ReviewDBInterface reviewRepository;
	 
	 @GetMapping("/login")
	 public String page(Model model) {
		 
		 log.trace("A TRACE Message");
		 log.debug("A DEBUG Message");
		 log.info("An INFO Message");
		 log.warn("A WARN Message");
		 log.error("An ERROR Message");
		 return "login";
		 
	 }
}
