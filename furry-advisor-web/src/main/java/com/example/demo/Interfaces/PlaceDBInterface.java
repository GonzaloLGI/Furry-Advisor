package com.example.demo.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.LocationDB;
import com.example.demo.Entidades.PlaceDB;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

//Clase de la interfaz-repositorio encargada de gestionar el acceso y manipulación de los
//objetos de la clase Place
public interface PlaceDBInterface extends JpaRepository<PlaceDB, Integer> {
	List<PlaceDB> findByName(String name);
	List<PlaceDB> findByType(String type);
	List<PlaceDB> findByCity(LocationDB city);
	List<PlaceDB> findByCityAndType(LocationDB city,String type);
	
	
	//List<PlaceDB> findByNameSorted(String name, Sort sort);
	//List<PlaceDB> findByTypeSorted(String type, Sort sort);
	//List<PlaceDB> findByCitySorted(String city, Sort sort);
}
