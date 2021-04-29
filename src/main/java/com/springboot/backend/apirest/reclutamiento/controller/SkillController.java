package com.springboot.backend.apirest.reclutamiento.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.apirest.reclutamiento.model.Skill;
import com.springboot.backend.apirest.reclutamiento.service.ISkillService;

@RestController
@RequestMapping("/api")
public class SkillController {
	
	@Autowired
	private ISkillService service;
	
	@GetMapping("/skills")
	public ResponseEntity<List<Skill>> listar(){
		List<Skill> lista = service.findAll();
		return new ResponseEntity<List<Skill>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/skills/{id}")
	public ResponseEntity<Skill> listarPorId(@PathVariable Integer id) throws Exception{
		Skill obj = service.findById(id);
		return new ResponseEntity<Skill>(obj, HttpStatus.OK);
	}
	
	@PostMapping("/skills")
	public ResponseEntity<Skill> guardar(@Valid @RequestBody Skill skill){
		Skill obj = service.save(skill);
		return new ResponseEntity<Skill>(obj, HttpStatus.OK);
	}
	
	@PutMapping("/skills")
	public ResponseEntity<Skill> modificar(@Valid @RequestBody Skill skill){
		Skill obj = service.update(skill);
		return new ResponseEntity<Skill>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/skills/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
		service.deleteById(id);
		return new ResponseEntity<Object>("Skill " + id + " eliminado.", HttpStatus.OK);
	}
}
