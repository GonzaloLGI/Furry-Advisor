package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDBInterface extends JpaRepository<ReviewDB,Integer> {
	List<ReviewDB> findByRating(int rating);
}
