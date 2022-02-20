package com.example.demo.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.PlaceDB;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public interface PlaceDBInterface extends JpaRepository<PlaceDB, Integer> {
	List<PlaceDB> findByName(String name);
	List<PlaceDB> findByType(String type);
	List<PlaceDB> findByCity(String city);
	
	List<PlaceDB> findByNameSorted(String name, Sort sort);
	List<PlaceDB> findByTypeSorted(String type, Sort sort);
	List<PlaceDB> findByCitySorted(String city, Sort sort);
}
