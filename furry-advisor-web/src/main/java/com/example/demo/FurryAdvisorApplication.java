package com.example.demo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class FurryAdvisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FurryAdvisorApplication.class, args);
	}
	
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        ds.setUrl("jdbc:mysql://localhost:3306/posts");
        ds.setUsername("root");
        ds.setPassword("nuevacontraseñafurry");
        return ds;
    }

}
