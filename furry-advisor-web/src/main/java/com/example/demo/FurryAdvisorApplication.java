package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@SpringBootApplication
public class FurryAdvisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FurryAdvisorApplication.class, args);
	}


}
