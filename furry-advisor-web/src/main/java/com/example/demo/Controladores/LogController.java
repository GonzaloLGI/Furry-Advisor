package com.example.demo.Controladores;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Interfaces2.ReviewDBInterface;

@Controller
public class LogController {
	 private Logger log = (Logger) LoggerFactory.getLogger(LogController.class);
	 
	 @Autowired
	 private ReviewDBInterface reviewRepository;
	 
	 @GetMapping("/login")
	 public String page(Model model) {
		 /*List<User> users = new ArrayList<>();
		 
		 users.add(new User("Pedro","Pascal",""));
		 users.add(new User("Boba","Fett",""));
		 model.addAttribute("users",users);*/
		 
		 /*List<ReviewDB> place = reviewRepository.findByRating(5);
		 List<CommentDB> cm = place.get(0).getComments();
		 System.out.println(cm.get(0).getDate());*/
		 
		 log.trace("A TRACE Message");
		 log.debug("A DEBUG Message");
		 log.info("An INFO Message");
		 log.warn("A WARN Message");
		 log.error("An ERROR Message");
		 return "login";
	 }
}
