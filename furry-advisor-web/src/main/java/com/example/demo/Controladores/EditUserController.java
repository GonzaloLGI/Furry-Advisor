package com.example.demo.Controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entidades.UserDB;
import com.example.demo.Services.UserService;

@Controller
public class EditUserController {
	
	@Autowired
	public UserService userRepository;
	
	@GetMapping("/editUser/{nickname}")
	public String editUser(Model model, HttpSession http, @PathVariable String nickname) {
		UserDB user = userRepository.findByNickname(nickname).get(0);
		model.addAttribute("place", http.getAttribute("place"));
        model.addAttribute("offer", http.getAttribute("offer"));
        model.addAttribute("user_name", nickname);
        model.addAttribute("user_password", user.getPassword());
		return "edit_user";
	}
}
