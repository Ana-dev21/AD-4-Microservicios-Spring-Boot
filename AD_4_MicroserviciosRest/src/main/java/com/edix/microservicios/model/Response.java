package com.edix.microservicios.model;

/**
 * Modelo de Respuesta que devuelve el status de la petición, los datos a mostrar y un mensaje informativo
 *
 * @param <T> Dependiendo del tipo de dato que se quiera devolver
 * 
 */
public class Response<T> {
	private String status;
	private T data;
	private String message;
	
	public Response() {

	}
	
	public Response(String status, T data) {
		this.status = status;
		this.data = data;
	}
	
	
	public Response(String status, T data,String message ) {
		this.status = status;
		this.data = data;
		this.message = message;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}		
}
