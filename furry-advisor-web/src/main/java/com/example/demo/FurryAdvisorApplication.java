package com.example.demo;

import java.io.Serializable;
import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;

@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession
@Configuration
public class FurryAdvisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FurryAdvisorApplication.class, args);
	}
	
	@Bean
    public HazelcastInstance hazelcastInstance(Config config) {
        return Hazelcast.newHazelcastInstance(config);
    }

	@Bean
	public Config config(){
		Config config = new Config();

		JoinConfig join = config.getNetworkConfig().getJoin();
		join.getMulticastConfig().setEnabled(true);
		
		MapConfig usersMapConfig = new MapConfig().setName("furry-advisor-web");
        config.addMapConfig(usersMapConfig);
		

		return config;
	}
	
	@Bean
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
        return new HazelcastCacheManager(hazelcastInstance);
    }

}
