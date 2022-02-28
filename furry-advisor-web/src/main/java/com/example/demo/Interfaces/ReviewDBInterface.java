package com.example.demo.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Entidades.UserDB;

//Clase de la interfaz-repositorio encargada de gestionar el acceso y manipulación de los
//objetos de la clase Review
public interface ReviewDBInterface extends JpaRepository<ReviewDB,Integer> {
	List<ReviewDB> findByRating(int rating);
	List<ReviewDB> findByUserRef(UserDB userRef);
	List<ReviewDB> findByPlacRef(PlaceDB placRef);
}
