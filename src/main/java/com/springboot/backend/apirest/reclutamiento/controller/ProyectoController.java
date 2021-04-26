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

import com.springboot.backend.apirest.reclutamiento.model.Proyecto;
import com.springboot.backend.apirest.reclutamiento.service.IProyectoService;

@RestController
@RequestMapping("/api")
public class ProyectoController {
	
	@Autowired
	private IProyectoService service;
	
	@GetMapping("/proyectos")
	public ResponseEntity<List<Proyecto>> listar(){
		List<Proyecto> lista = service.findAll();
		return new ResponseEntity<List<Proyecto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/proyectos/{id}")
	public ResponseEntity<Proyecto> listarPorId(@PathVariable Integer id) throws Exception{
		Proyecto obj = service.findById(id);
		return new ResponseEntity<Proyecto>(obj, HttpStatus.OK);
	}
	
	@PostMapping("/proyectos")
	public ResponseEntity<Proyecto> guardar(@Valid @RequestBody Proyecto proyecto){
		Proyecto obj = service.save(proyecto);
		return new ResponseEntity<Proyecto>(obj, HttpStatus.OK);
	}
	
	@PutMapping("/proyectos")
	public ResponseEntity<Proyecto> modificar(@Valid @RequestBody Proyecto proyecto){
		Proyecto obj = service.update(proyecto);
		return new ResponseEntity<Proyecto>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/proyectos/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
		service.deleteById(id);
		return new ResponseEntity<Object>("Proyecto " + id + " eliminado.", HttpStatus.OK);
	}
}
