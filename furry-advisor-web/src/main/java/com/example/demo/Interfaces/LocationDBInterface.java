package com.example.demo.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.LocationDB;
import com.example.demo.Entidades.PlaceDB;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

//Clase de la interfaz-repositorio encargada de gestionar el acceso y manipulación de los
//objetos de la clase Location
public interface LocationDBInterface extends JpaRepository<LocationDB, Integer> {
	List<LocationDB> findAll();
	List<LocationDB> findAllByOrderByName();
	
	
	
}
