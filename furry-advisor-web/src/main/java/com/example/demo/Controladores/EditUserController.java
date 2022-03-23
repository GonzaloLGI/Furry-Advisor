package com.example.demo.Controladores;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditUserController {
	@GetMapping("/editUser")
	public String editUser(Model model, HttpSession http) {
		model.addAttribute("place", http.getAttribute("place"));
        model.addAttribute("offer", http.getAttribute("offer"));
		return "edit_user";
	}
}
