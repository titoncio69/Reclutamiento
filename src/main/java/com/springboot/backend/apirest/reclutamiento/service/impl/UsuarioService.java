package com.springboot.backend.apirest.reclutamiento.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.apirest.reclutamiento.exception.ModeloNotFoundException;
import com.springboot.backend.apirest.reclutamiento.model.Usuario;
import com.springboot.backend.apirest.reclutamiento.repository.IUsuarioRepository;
import com.springboot.backend.apirest.reclutamiento.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepository repo;

	@Override
	public Usuario findById(Integer id) throws Exception {
		Optional<Usuario> op = repo.findById(id);
		if (!op.isPresent()) {
			throw new ModeloNotFoundException("Usuario no encontrado " + id);
		}
		return op.get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return repo.findAll();
	}

	@Override
	public Usuario save(Usuario e) {
		return repo.save(e);
	}

	@Override
	public Usuario update(Usuario e) {
		return repo.save(e);
	}

	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Usuario> op = repo.findById(id);
		if (!op.isPresent()) {
			throw new ModeloNotFoundException("Usuario no encontrado " + id);
		}
		repo.deleteById(id);
		return true;
	}

}
