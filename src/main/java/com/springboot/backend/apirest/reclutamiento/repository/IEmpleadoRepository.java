package com.springboot.backend.apirest.reclutamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.backend.apirest.reclutamiento.model.Empleado;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer>{

}
