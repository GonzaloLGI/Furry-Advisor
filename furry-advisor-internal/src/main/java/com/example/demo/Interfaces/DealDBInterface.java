package com.example.demo.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.PlaceDB;

//Clase de la interfaz-repositorio encargada de gestionar el acceso y manipulación de los
//objetos de la clase Deal
public interface DealDBInterface extends JpaRepository<DealDB,Integer> {
	List<DealDB> findByHeader(String header);
	List<DealDB> findAllByPlaceOriginIsNotNull();
	List<DealDB> findAllByPlaceOrigin(PlaceDB placeOrigin);
}
