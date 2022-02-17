package com.example.demo.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.DealDB;

public interface DealDBInterface extends JpaRepository<DealDB,Integer> {
	List<DealDB> findByHeader(String header);
}
