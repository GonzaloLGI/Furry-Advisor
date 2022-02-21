package com.example.demo.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.UserDB;

//Clase de la interfaz-repositorio encargada de gestionar el acceso y manipulación de los
//objetos de la clase User
public interface UserDBInterface extends JpaRepository<UserDB,Integer> {
	List<UserDB> findByNickname(String nickname);
	List<UserDB> findByEmail(String email);
}