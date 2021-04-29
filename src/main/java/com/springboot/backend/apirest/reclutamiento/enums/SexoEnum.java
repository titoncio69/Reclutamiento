package com.springboot.backend.apirest.reclutamiento.enums;

public enum SexoEnum {
	
	FEMENINO("FEMENINO"),
	MASCULINO("MASCULINO");
	
	private final String nombre;

	private SexoEnum(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
