package com.example.demo.Interfaces;

import java.util.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.CommentDB;

public interface CommentDBInterface extends JpaRepository<CommentDB,Integer> {
	ArrayList<CommentDB> findByDate(Date date);
}
