package clases;

public class Bicicleta extends Vehiculo {

	private String tipoFreno;

	public Bicicleta(int idVehiculo) {
		super(idVehiculo);
	}

	public Bicicleta(String marca, String modelo, float precioPorHora, String tipoFreno) {
		super(marca, modelo, precioPorHora);
		this.tipoFreno = tipoFreno;
	}

	public String getTipoFreno() {
		return tipoFreno;
	}

	public void setTipoFreno(String tipoFreno) {
		this.tipoFreno = tipoFreno;
	}

	@Override
	public String toString() {
		return super.toString() + "Bicicleta [tipoFreno=" + tipoFreno + "]";
	}

	public void descripcion() {
		super.descripcion();
		System.out.println("Tipo de Freno: " + tipoFreno);
	}

}
