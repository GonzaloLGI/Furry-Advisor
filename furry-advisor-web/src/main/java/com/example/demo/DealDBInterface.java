package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DealDBInterface extends JpaRepository<DealDB,Integer> {
	List<DealDB> findByHeader(String header);
}
