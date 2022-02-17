package com.example.demo.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.PlaceDB;

public interface PlaceDBInterface extends JpaRepository<PlaceDB, Integer> {
	List<PlaceDB> findByName(String name);
	List<PlaceDB> findByType(String type);
}
