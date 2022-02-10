package com.example.demo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDBInterface extends JpaRepository<CommentDB,Integer> {
	List<CommentDB> findByDate(Date date);
}
