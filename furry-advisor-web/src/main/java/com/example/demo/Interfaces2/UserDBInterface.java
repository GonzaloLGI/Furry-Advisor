package com.example.demo.Interfaces2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades2.UserDB;

public interface UserDBInterface extends JpaRepository<UserDB,Integer> {
	List<UserDB> findByNickname(String nickname);
}
