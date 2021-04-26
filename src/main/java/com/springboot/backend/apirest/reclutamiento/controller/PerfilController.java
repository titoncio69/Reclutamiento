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

import com.springboot.backend.apirest.reclutamiento.model.Perfil;
import com.springboot.backend.apirest.reclutamiento.service.IPerfilService;

@RestController
@RequestMapping("/api")
public class PerfilController {
	
	@Autowired
	private IPerfilService service;
	
	@GetMapping("/perfiles")
	public ResponseEntity<List<Perfil>> listar(){
		List<Perfil> lista = service.findAll();
		return new ResponseEntity<List<Perfil>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/perfiles/{id}")
	public ResponseEntity<Perfil> listarPorId(@PathVariable Integer id) throws Exception{
		Perfil obj = service.findById(id);
		return new ResponseEntity<Perfil>(obj, HttpStatus.OK);
	}
	
	@PostMapping("/perfiles")
	public ResponseEntity<Perfil> guardar(@Valid @RequestBody Perfil perfil){
		Perfil obj = service.save(perfil);
		return new ResponseEntity<Perfil>(obj, HttpStatus.OK);
	}
	
	@PutMapping("/perfiles")
	public ResponseEntity<Perfil> modificar(@Valid @RequestBody Perfil perfil){
		Perfil obj = service.update(perfil);
		return new ResponseEntity<Perfil>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/perfiles/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
		service.deleteById(id);
		return new ResponseEntity<Object>("Perfil " + id + " eliminado.", HttpStatus.OK);
	}
}
