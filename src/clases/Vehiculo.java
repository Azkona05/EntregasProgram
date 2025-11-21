package clases;

public class Vehiculo {

	private int idVehiculo;
	private static int contador = 1;
	private String marca;
	private String modelo;
	private float precioPorHora;

	public Vehiculo(int idVehiculo) {
		this.idVehiculo = contador++;
	}

	public Vehiculo(String marca, String modelo, float precioPorHora) {
		super();
		this.idVehiculo = contador++;
		this.marca = marca;
		this.modelo = modelo;
		this.precioPorHora = precioPorHora;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Vehiculo.contador = contador;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getPrecioPorHora() {
		return precioPorHora;
	}

	public void setPrecioPorHora(float precioPorHora) {
		this.precioPorHora = precioPorHora;
	}

	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", marca=" + marca + ", modelo=" + modelo + ", precioPorHora="
				+ precioPorHora + "]";
	}

	public float calcularPrecioAlquiler(float horas) {
		return horas * precioPorHora;
	}

	public void descripcion() {
		System.out.println("Id del vehiculo: " + idVehiculo);
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
		System.out.println("Precio por hora: " + precioPorHora);
	}

}
