package clases;

import java.time.LocalDate;

import utilidades.Util;

public class Socio extends PersonaSB{

	protected String nombreBiblioteca;
	protected int mesAlta;
	protected int anioAlta;
	protected int numLibros;
	protected static float cuotaBaseMensual = 12;

	public Socio() {

	}

	
	public Socio(String dni, String nombreCompleto, String nombreBiblioteca, int mesAlta, int anioAlta, int numLibros) {
		super(dni, nombreCompleto);
		this.nombreBiblioteca = nombreBiblioteca;
		this.mesAlta = mesAlta;
		this.anioAlta = anioAlta;
		this.numLibros = numLibros;
	}


	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}

	public void setNombreBiblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
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

	public int getMesAlta() {
		return mesAlta;
	}

	public void setMesAlta(int mesAlta) {
		this.mesAlta = mesAlta;
	}

	public int getAnioAlta() {
		return anioAlta;
	}

	public void setAnioAlta(int anioAlta) {
		this.anioAlta = anioAlta;
	}

	public int getNumLibros() {
		return numLibros;
	}

	public void setNumLibros(int numLibros) {
		this.numLibros = numLibros;
	}

	
	
	@Override
	public String toString() {
		return super.toString() + "Socio [nombreBiblioteca=" + nombreBiblioteca + ", mesAlta=" + mesAlta + ", anioAlta=" + anioAlta
				+ ", numLibros=" + numLibros + "]";
	}


	public void setDatos(String dni) {
		super.setDatos(dni);
		this.nombreBiblioteca = Util.introducirCadena("Introduce el nombre de la biblioteca: ");
		this.mesAlta = Util.leerInt("Introduce el mes de alta (número): ");
	    this.anioAlta = Util.leerInt("Introduce el año de alta: ");
	    this.numLibros = Util.leerInt("Introduce el número de libros: ");
	}

	public float calcularCuotaFinal() {
		double cuotaFinal = cuotaBaseMensual;
		if (numLibros > 3) {
			int librosExtra = numLibros - 3;
			cuotaFinal += (librosExtra * 1.0);
		}
		int aniosAntiguedad = LocalDate.now().getYear() - anioAlta;
		if (aniosAntiguedad >= 8) {
			cuotaFinal -= 2.0;
		}
		return (float) cuotaFinal;
	}
}
