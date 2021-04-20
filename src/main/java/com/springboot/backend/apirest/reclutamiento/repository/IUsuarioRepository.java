package com.springboot.backend.apirest.reclutamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.apirest.reclutamiento.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
}
