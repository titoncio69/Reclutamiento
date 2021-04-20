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

import com.springboot.backend.apirest.reclutamiento.model.Usuario;
import com.springboot.backend.apirest.reclutamiento.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> lista = service.findAll();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable Integer id) throws Exception{
		Usuario obj = service.findById(id);
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> guardar(@Valid @RequestBody Usuario usuario){
		Usuario obj = service.save(usuario);
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}
	
	@PutMapping("/usuarios")
	public ResponseEntity<Usuario> modificar(@Valid @RequestBody Usuario usuario){
		Usuario obj = service.update(usuario);
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
		service.deleteById(id);
		return new ResponseEntity<Object>("Usuario " + id + " eliminado.", HttpStatus.OK);
	}
}
