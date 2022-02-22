package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
