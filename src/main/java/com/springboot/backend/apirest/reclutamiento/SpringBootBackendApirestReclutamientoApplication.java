package com.springboot.backend.apirest.reclutamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootBackendApirestReclutamientoApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApirestReclutamientoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String pass = "Escalab.2021";
		for (int i = 0; i < 5; i++) {
			String pcrypt = bcrypt.encode(pass);
			System.out.println(pcrypt);
		}
	}

}
