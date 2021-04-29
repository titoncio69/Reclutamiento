package com.springboot.backend.apirest.reclutamiento.enums;

public enum DiaEnum {

	LUNES("LUNES"), 
	MARTES("MARTES"), 
	MIERCOLES("MIERCOLES"), 
	JUEVES("JUEVES"), 
	VIERNES("VIERNES"), 
	SABADO("SABADO"),
	DOMINGO("DOMINGO");

	private final String nombre;

	private DiaEnum(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

}
