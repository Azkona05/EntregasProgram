package clases;

public class Trabajador extends Persona {

	private String usuario;
	private String contrasenia;
	private Cargo cargo;
	
	public Trabajador () {
		
	}
	
	public Trabajador(String dni, String nombre, String usuario, String contrasenia, Cargo cargo) {
		super(dni, nombre);
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.cargo = cargo;
	}


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return super.toString() + "Trabajador [usuario=" + usuario + ", contrasenia=" + contrasenia + ", cargo=" + cargo + "]";
	}

	@Override
	public void visualizacion() {
		System.out.println("DNI: " + super.dni);
		System.out.println("NOMBRE: " + super.nombre);
		System.out.println("USUARIO: " + this.usuario);
		System.out.println("CONTRASEÑA: " + this.contrasenia);
		System.out.println("CARGO: " + this.cargo);
		
	}

}
