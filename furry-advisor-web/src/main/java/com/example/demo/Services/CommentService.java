package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entidades.CommentDB;
import com.example.demo.Interfaces.CommentDBInterface;

public class CommentService {
	
	@Autowired
	private CommentDBInterface commentRepository;
	
	public ArrayList<CommentDB> findByDate(Date date){
		return commentRepository.findByDate(date);
	}
}
