package com.edix.microservicios.model.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


/**
 * The persistent class for the comerciales database table.
 * 
 */
@Entity
@Table(name="comerciales")
@NamedQuery(name="Comercial.findAll", query="SELECT c FROM Comercial c")
public class Comercial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comercial")
	private int idComercial;

	private String apellido1;

	private String apellido2;

	private double comision;

	private String nombre;

	public Comercial() {
	}

	public int getIdComercial() {
		return this.idComercial;
	}

	public void setIdComercial(int idComercial) {
		this.idComercial = idComercial;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public double getComision() {
		return this.comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Comercial [idComercial=" + idComercial + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", comision=" + comision + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idComercial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Comercial))
			return false;
		Comercial other = (Comercial) obj;
		return idComercial == other.idComercial;
	}

}