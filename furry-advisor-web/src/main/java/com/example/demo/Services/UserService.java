package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.CommentDB;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Interfaces.UserDBInterface;

@Service
public class UserService {

	@Autowired
	private UserDBInterface userRepository;
	
	public List<UserDB> findByNickname(String nickname){
		return userRepository.findByNickname(nickname);
	}
	
	public List<UserDB> findByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	public void save(UserDB user){
		userRepository.save(user);
	}
	
	public void delete(UserDB user){
		userRepository.delete(user);
	}
}
