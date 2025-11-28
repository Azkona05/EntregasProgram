package clases;

import utilidades.Util;

public class Bibliotecario extends Socio {

    private static int plusFijo = 30;
    private String seccion; 
    public Bibliotecario() {
        super();
    }

    public Bibliotecario(String dni, String nombreCompleto, String nombreBiblioteca, int mesAlta, int anioAlta,
			int numLibros, String seccion) {
		super(dni, nombreCompleto, nombreBiblioteca, mesAlta, anioAlta, numLibros);
		this.seccion = seccion;
	}



	public static int getPlusFijo() {
        return plusFijo;
    }

    public static void setPlusFijo(int plusFijo) {
        Bibliotecario.plusFijo = plusFijo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return super.toString() + " Cargo: Bibliotecario [Sección=" + seccion + ", Plus=" + plusFijo + "€]";
    }

    @Override
    public void setDatos(String dni) {
        super.setDatos(dni);
        this.seccion = Util.introducirCadena("Introduce la sección (Infantil, Historia, etc.): ");
    }
}