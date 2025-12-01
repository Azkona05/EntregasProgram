package clases;

public abstract class Persona {

	protected String dni;
	protected String nombre;
	
	public Persona() {
		
	}
	
	public Persona(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + "]";
	}
	
	public abstract void visualizacion();
}
