package com.springboot.backend.apirest.reclutamiento;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.backend.apirest.reclutamiento.enums.NivelEnum;
import com.springboot.backend.apirest.reclutamiento.model.Perfil;

@SpringBootApplication
public class SpringBootBackendApirestReclutamientoApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApirestReclutamientoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String pass = "12345";
		for (int i = 0; i < 4; i++) {
			String pcrypt = bcrypt.encode(pass);
			System.out.println(pcrypt);
		}
	}

}
