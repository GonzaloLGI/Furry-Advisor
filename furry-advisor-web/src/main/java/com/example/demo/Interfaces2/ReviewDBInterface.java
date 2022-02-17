package com.example.demo.Interfaces2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades2.ReviewDB;

public interface ReviewDBInterface extends JpaRepository<ReviewDB,Integer> {
	List<ReviewDB> findByRating(int rating);
}
