package com.example.demo.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.ReviewDB;
import com.example.demo.Entidades.UserDB;

public interface ReviewDBInterface extends JpaRepository<ReviewDB,Integer> {
	List<ReviewDB> findByRating(int rating);
	List<ReviewDB> findByUserDB(UserDB user_or);
}
