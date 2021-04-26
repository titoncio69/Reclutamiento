package com.springboot.backend.apirest.reclutamiento.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.apirest.reclutamiento.exception.ModeloNotFoundException;
import com.springboot.backend.apirest.reclutamiento.model.Empleado;
import com.springboot.backend.apirest.reclutamiento.repository.IEmpleadoRepository;
import com.springboot.backend.apirest.reclutamiento.service.IEmpleadoService;

@Service
public class EmpleadoService implements IEmpleadoService{
	
	@Autowired
	private IEmpleadoRepository repo;

	@Override
	public Empleado findById(Integer id) throws Exception {
		Optional<Empleado> op = repo.findById(id);
		if (!op.isPresent()) {
			throw new ModeloNotFoundException("Empleado no encontrado " + id);
		}
		return op.get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		return repo.findAll();
	}

	@Override
	public Empleado save(Empleado e) {
		return repo.save(e);
	}

	@Override
	public Empleado update(Empleado e) {
		return repo.save(e);
	}

	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Empleado> op = repo.findById(id);
		if (!op.isPresent()) {
			throw new ModeloNotFoundException("Empleado no encontrado " + id);
		}
		repo.deleteById(id);
		return true;
	}

}
