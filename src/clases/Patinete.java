package clases;

public class Patinete extends Vehiculo {

	private int autonomiaBateria;

	public Patinete(int idVehiculo) {
		super(idVehiculo);
	}

	public Patinete(String marca, String modelo, float precioPorHora, int autonomiaBateria) {
		super(marca, modelo, precioPorHora);
		this.autonomiaBateria = autonomiaBateria;
	}

	public int getAutonomiaBateria() {
		return autonomiaBateria;
	}

	public void setAutonomiaBateria(int autonomiaBateria) {
		this.autonomiaBateria = autonomiaBateria;
	}

	@Override
	public String toString() {
		return super.toString() + "Patinete [autonomiaBateria=" + autonomiaBateria + "]";
	}

	public void descripcion() {
		super.descripcion();
		System.out.println("Autonomia (Km): " + autonomiaBateria);
	}
}
