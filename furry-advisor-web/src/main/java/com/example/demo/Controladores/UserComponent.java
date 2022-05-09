package com.example.demo.Controladores;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.Entidades.UserDB;

@Component
@SessionScope
public class UserComponent implements Serializable{
	private UserDB user;
	
	public UserDB getLoggedUser() {
		return user;
	}
	
	public void setLoggedUser(UserDB actUser) {
		this.user = actUser;
	}
	
	public boolean isLoggedUser() {
		return this.user!=null;
	}
}
