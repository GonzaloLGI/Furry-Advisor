package com.example.demo.Interfaces;

import java.util.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.CommentDB;
import com.example.demo.Entidades.ReviewDB;

//Clase de la interfaz-repositorio encargada de gestionar el acceso y manipulación de los
//objetos de la clase Comment
public interface CommentDBInterface extends JpaRepository<CommentDB,Integer> {
	ArrayList<CommentDB> findByDate(Date date);
	ArrayList<CommentDB> findByReviewRef(ReviewDB reviewRef);
}
