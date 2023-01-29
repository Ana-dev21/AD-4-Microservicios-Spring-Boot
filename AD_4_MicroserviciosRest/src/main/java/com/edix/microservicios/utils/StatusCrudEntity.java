package com.edix.microservicios.utils;

/**
 * Clase que establece 3 tipos de estado predefinidos, para devolver en una clase Response<T>
 *
 */
public enum StatusCrudEntity {

	OK(1),
	Other(2),
	Error(0);
	
	private final int value;
	
	StatusCrudEntity(int value) {
		this.value = value;
	}
	
	public int value() {
		return this.value;
	}
}
