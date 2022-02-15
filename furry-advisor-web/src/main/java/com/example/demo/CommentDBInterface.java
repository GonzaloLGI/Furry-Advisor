package com.example.demo;

import java.util.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDBInterface extends JpaRepository<CommentDB,Integer> {
	ArrayList<CommentDB> findByDate(Date date);
}
