package com.springboot.backend.apirest.reclutamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.backend.apirest.reclutamiento.model.Skill;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, Integer>{

}
