package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceDBInterface extends JpaRepository<PlaceDB, Integer> {
	List<PlaceDB> findByName(String name);
	List<PlaceDB> findByType(String type);
}
