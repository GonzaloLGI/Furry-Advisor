package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDBInterface extends JpaRepository<CommentDB,Integer> {
	List<UserDB> findByUser(UserDB user);
}
