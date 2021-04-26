package com.springboot.backend.apirest.reclutamiento.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.apirest.reclutamiento.exception.ModeloNotFoundException;
import com.springboot.backend.apirest.reclutamiento.model.Skill;
import com.springboot.backend.apirest.reclutamiento.repository.ISkillRepository;
import com.springboot.backend.apirest.reclutamiento.service.ISkillService;

@Service
public class SkillService implements ISkillService{
	
	@Autowired
	private ISkillRepository repo;

	@Override
	public Skill findById(Integer id) throws Exception {
		Optional<Skill> op = repo.findById(id);
		if (!op.isPresent()) {
			throw new ModeloNotFoundException("Skill no encontrado " + id);
		}
		return op.get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Skill> findAll() {
		return repo.findAll();
	}

	@Override
	public Skill save(Skill e) {
		return repo.save(e);
	}

	@Override
	public Skill update(Skill e) {
		return repo.save(e);
	}

	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Skill> op = repo.findById(id);
		if (!op.isPresent()) {
			throw new ModeloNotFoundException("Usuario no encontrado " + id);
		}
		repo.deleteById(id);
		return true;
	}

}
