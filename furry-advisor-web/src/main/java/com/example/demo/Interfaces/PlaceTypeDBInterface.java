package com.example.demo.Interfaces;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.LocationDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Entidades.PlaceTypeDB;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

//Clase de la interfaz-repositorio encargada de gestionar el acceso y manipulación de los
//objetos de la clase Location
public interface PlaceTypeDBInterface extends JpaRepository<PlaceTypeDB, Integer> {
	List<PlaceTypeDB> findAll();
	@Cacheable("placetype")
	List<PlaceTypeDB> findAllByOrderByType();
	List<PlaceTypeDB> findByType(String type);
	
	
	
}
