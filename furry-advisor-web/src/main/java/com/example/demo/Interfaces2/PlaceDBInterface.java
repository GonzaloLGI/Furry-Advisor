package com.example.demo.Interfaces2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades2.PlaceDB;

public interface PlaceDBInterface extends JpaRepository<PlaceDB, Integer> {
	List<PlaceDB> findByName(String name);
	List<PlaceDB> findByType(String type);
}
