package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.CommentDB;
import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Interfaces.CommentDBInterface;

@Service
public class CommentService {
	
	@Autowired
	private CommentDBInterface commentRepository;
	
	public ArrayList<CommentDB> findByDate(Date date){
		return commentRepository.findByDate(date);
	}
	
	public ArrayList<CommentDB> findByReviewRef(ReviewDB reviewRef){
		return commentRepository.findByReviewRef(reviewRef);
	}
	
	public void save(CommentDB comment){
		commentRepository.save(comment);
	}
}
