package com.springboot.backend.apirest.reclutamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.backend.apirest.reclutamiento.model.Perfil;

@Repository
public interface IPerfilRepository extends JpaRepository<Perfil, Integer>{

}
