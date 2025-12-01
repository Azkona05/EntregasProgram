package clases;

import java.time.LocalDate;
import java.util.HashMap;

public class Cliente extends Persona {

	private LocalDate fechaAlta;
	private HashMap<String, Entrenamiento> entrenamientos;

	public Cliente() {
		super();
	}

	public Cliente(String dni, String nombre, LocalDate fechaAlta, HashMap<String, Entrenamiento> entrenamientos) {
		super(dni, nombre);
		this.fechaAlta = fechaAlta;
		this.entrenamientos = entrenamientos;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public HashMap<String, Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}

	public void setEntrenamientos(HashMap<String, Entrenamiento> entrenamientos) {
		this.entrenamientos = new HashMap<String, Entrenamiento>();
	}

	@Override
	public String toString() {
		return "Cliente [fechaAlta=" + fechaAlta + ", entrenamientos=" + entrenamientos.values() + "]";
	}

	@Override
	public void visualizacion() {
		// TODO Auto-generated method stub

	}

}
