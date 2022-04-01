package com.example.demo.Seguridad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.Controladores.UserComponent;
import com.example.demo.Entidades.UserDB;
import com.example.demo.Services.UserService;

@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserComponent component;
	
	@Autowired
	private UserService userRepository;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		List<UserDB> listUser = userRepository.findByNickname(auth.getName());
		if (listUser.isEmpty()) {
			throw new BadCredentialsException("User not found");
		}
		UserDB user = (UserDB)(userRepository.findByNickname(auth.getName()).get(0));
		if (user == null) {
			throw new BadCredentialsException("User not found");
		}
		String password = (String) auth.getCredentials();
		
		if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
			throw new BadCredentialsException("Wrong password");
		}
		component.setLoggedUser(user);
		List<GrantedAuthority> roles = new ArrayList<>();
		for (String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		return new UsernamePasswordAuthenticationToken(user.getNickname(), password, roles);
	 	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		System.out.println(authentication);
		return true;//(UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
	
}
