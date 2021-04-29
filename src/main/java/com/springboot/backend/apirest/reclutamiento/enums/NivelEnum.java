package com.springboot.backend.apirest.reclutamiento.enums;

public enum NivelEnum {
	
	JUNIOR("JUNIOR"),
	SEMISENIOR("SEMISENIOR"),
	SENIOR("SENIOR");
	
	private final String nombre;

	private NivelEnum(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
