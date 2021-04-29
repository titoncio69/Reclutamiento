package com.springboot.backend.apirest.reclutamiento.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.apirest.reclutamiento.exception.ModeloNotFoundException;
import com.springboot.backend.apirest.reclutamiento.model.Perfil;
import com.springboot.backend.apirest.reclutamiento.repository.IPerfilRepository;
import com.springboot.backend.apirest.reclutamiento.service.IPerfilService;

@Service
public class PerfilService implements IPerfilService{
	
	@Autowired
	private IPerfilRepository repo;
	
	@Override
	public Perfil findById(Integer id) throws Exception {
		Optional<Perfil> op = repo.findById(id);
		if (!op.isPresent()) {
			throw new ModeloNotFoundException("Perfil no encontrado " + id);
		}
		return op.get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Perfil> findAll() {
		return repo.findAll();
	}

	@Override
	public Perfil save(Perfil e) {
		return repo.save(e);
	}

	@Override
	public Perfil update(Perfil e) {
		return repo.save(e);
	}

	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Perfil> op = repo.findById(id);
		if (!op.isPresent()) {
			throw new ModeloNotFoundException("Skill no encontrado " + id);
		}
		repo.deleteById(id);
		return true;
	}

}
