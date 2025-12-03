package clases;

import java.time.LocalDate;

public class Entrenamiento {

	private static int contador = 100;
	private String codigo;
	private LocalDate fecha;
	private String nombre;
	private int numRepeticiones;

	public Entrenamiento() {
		super();
	}

	public Entrenamiento(LocalDate fecha, String nombre, int numRepeticiones) {
		super();
		this.codigo = "WOD-" + contador;
		contador++;
		this.fecha = fecha;
		this.nombre = nombre;
		this.numRepeticiones = numRepeticiones;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumRepeticiones() {
		return numRepeticiones;
	}

	public void setNumRepeticiones(int numRepeticiones) {
		this.numRepeticiones = numRepeticiones;
	}

	@Override
	public String toString() {
		return "Entrenamiento [codigo=" + codigo + ", fecha=" + fecha + ", nombre=" + nombre + ", numRepeticiones="
				+ numRepeticiones + "]";
	}

}
