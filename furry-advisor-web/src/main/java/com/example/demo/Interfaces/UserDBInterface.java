package com.example.demo.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.UserDB;

public interface UserDBInterface extends JpaRepository<UserDB,Integer> {
	List<UserDB> findByNickname(String nickname);
	
}
