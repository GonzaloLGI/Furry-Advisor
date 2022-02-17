package com.example.demo.Interfaces2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades2.DealDB;

public interface DealDBInterface extends JpaRepository<DealDB,Integer> {
	List<DealDB> findByHeader(String header);
}
