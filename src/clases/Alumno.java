package clases;

import java.time.LocalDate;

public class Alumno {

	private String nif;
	private String nombre;
	private LocalDate fecha;
	private Ciclo ciclo;
	private boolean repetidor;

	public Alumno(String nif) {
		this.nif = nif;
	}

	public Alumno(String nif, String nombre, LocalDate fecha, Ciclo ciclo, boolean repetidor) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.fecha = fecha;
		this.ciclo = ciclo;
		this.repetidor = repetidor;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}

	@Override
	public String toString() {
		return "Alumno [nif=" + nif + ", nombre=" + nombre + ", fecha=" + fecha + ", ciclo=" + ciclo + ", repetido="
				+ repetidor + "]";
	}

}
