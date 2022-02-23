package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.CommentDB;
import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Interfaces.ReviewDBInterface;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewDBInterface reviewRepository;
	
	public List<ReviewDB> findByRating(int rating){
		return reviewRepository.findByRating(rating);
	}
	
	public List<ReviewDB> findByUserRef(UserDB userRef){
		return reviewRepository.findByUserRef(userRef);
	}
	
	public void save(ReviewDB review){
		reviewRepository.save(review);
	}
}
