package com.springboot.backend.apirest.reclutamiento.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.apirest.reclutamiento.exception.ModeloNotFoundException;
import com.springboot.backend.apirest.reclutamiento.model.Proyecto;
import com.springboot.backend.apirest.reclutamiento.repository.IProyectoRepository;
import com.springboot.backend.apirest.reclutamiento.service.IProyectoService;

@Service
public class ProyectoService implements IProyectoService{

	@Autowired
	private IProyectoRepository repo;
	
	@Override
	public Proyecto findById(Integer id) throws Exception {
		Optional<Proyecto> op = repo.findById(id);
		if (!op.isPresent()) {
			throw new ModeloNotFoundException("Proyecto no encontrado " + id);
		}
		return op.get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Proyecto> findAll() {
		return repo.findAll();
	}

	@Override
	public Proyecto save(Proyecto e) {
		return repo.save(e);
	}

	@Override
	public Proyecto update(Proyecto e) {
		return repo.save(e);
	}

	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Proyecto> op = repo.findById(id);
		if (!op.isPresent()) {
			throw new ModeloNotFoundException("Proyecto no encontrado " + id);
		}
		repo.deleteById(id);
		return true;
	}

}
