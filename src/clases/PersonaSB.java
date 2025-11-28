package clases;

import utilidades.Util;

public abstract class PersonaSB {
	protected String dni;
	protected String nombreCompleto;
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombreCompleto=" + nombreCompleto + "]";
	}
	public PersonaSB(String dni, String nombreCompleto) {
		super();
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
	}
	
	public PersonaSB() {
		
	}
	
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public void setDatos(String dni) {
		this.dni = dni;
		nombreCompleto = Util.introducirCadena("Introduce nombre completo: ");
	}
}
