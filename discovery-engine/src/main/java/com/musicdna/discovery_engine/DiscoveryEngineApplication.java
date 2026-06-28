package com.musicdna.discovery_engine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.musicdna.discovery_engine.model.User;
import com.musicdna.discovery_engine.repository.UserRepository;

@SpringBootApplication
public class DiscoveryEngineApplication {
	@Bean
	CommandLineRunner seedDevUser(UserRepository userRepository) {   // ← Spring INJECTS the proxy here
    return args -> {
        if (userRepository.count() == 0) {
			User devUser = new User();
			userRepository.save(devUser);
		}
    };
}

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryEngineApplication.class, args);
	}

}
