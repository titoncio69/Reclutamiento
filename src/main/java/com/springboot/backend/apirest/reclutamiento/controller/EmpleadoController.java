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

import com.springboot.backend.apirest.reclutamiento.model.Empleado;
import com.springboot.backend.apirest.reclutamiento.service.IEmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService service;
	
	@GetMapping("/empleados")
	public ResponseEntity<List<Empleado>> listar(){
		List<Empleado> lista = service.findAll();
		return new ResponseEntity<List<Empleado>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> listarPorId(@PathVariable Integer id) throws Exception{
		Empleado obj = service.findById(id);
		return new ResponseEntity<Empleado>(obj, HttpStatus.OK);
	}
	
	@PostMapping("/empleados")
	public ResponseEntity<Empleado> guardar(@Valid @RequestBody Empleado empleado){
		Empleado obj = service.save(empleado);
		return new ResponseEntity<Empleado>(obj, HttpStatus.OK);
	}
	
	@PutMapping("/empleados")
	public ResponseEntity<Empleado> modificar(@Valid @RequestBody Empleado empleado){
		Empleado obj = service.update(empleado);
		return new ResponseEntity<Empleado>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
		service.deleteById(id);
		return new ResponseEntity<Object>("Empleado " + id + " eliminado.", HttpStatus.OK);
	}
}
