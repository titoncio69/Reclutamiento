package com.springboot.backend.apirest.reclutamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.apirest.reclutamiento.model.Proyecto;

public interface IProyectoRepository extends JpaRepository<Proyecto, Integer>{

}
