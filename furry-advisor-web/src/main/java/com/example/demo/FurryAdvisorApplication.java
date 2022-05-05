package com.example.demo;

import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession
public class FurryAdvisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FurryAdvisorApplication.class, args);
	}

	@Bean
	public Config config(){
		Config config = new Config();

		config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(true);
		//JoinConfig joinConfig = config.getNetworkConfig().getJoin();

		//joinConfig.getMulticastConfig().setEnabled(false);
		//joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Collections.singletonList("127.0.0.1"));

		return config;
	}

}
