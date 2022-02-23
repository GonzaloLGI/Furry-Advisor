package com.example.demo.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateReviewController {

	@GetMapping("/create_review")
	public String createReview(Model model) {
		return "create_review";
	}
}
