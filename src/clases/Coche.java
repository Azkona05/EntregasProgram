package clases;

public class Coche extends Vehiculo {

	private int numPuertas;
	private boolean esElectrico;

	public Coche(int idVehiculo) {
		super(idVehiculo);
	}

	public Coche(String marca, String modelo, float precioPorHora, int numPuertas,
			boolean esElectrico) {
		super(marca, modelo, precioPorHora);
		this.numPuertas = numPuertas;
		this.esElectrico = esElectrico;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public boolean isEsElectrico() {
		return esElectrico;
	}

	public void setEsElectrico(boolean esElectrico) {
		this.esElectrico = esElectrico;
	}

	@Override
	public String toString() {
		return super.toString() + "Coche [numPuertas=" + numPuertas + ", esElectrico=" + esElectrico + "]";
	}
	
	public void calcularPrecioAlquiler() {
		if (esElectrico == true) {
			super.calcularPrecioAlquiler((float) (super.getPrecioPorHora()*0.9));
		}
	}

}
