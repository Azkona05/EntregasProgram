package main;

import clases.LigaEsports;
import utilidades.Util;

public class Main {

	public static void main(String[] args) {

		LigaEsports lE = new LigaEsports();
		String nombre = Util.introducirCadena("Introduce nombre de la persona: ");
		lE.añadirCompetidor(nombre);
		lE.listarCompetidores();
		String nuevoNombre = Util.introducirCadena("Introduce nombre de la persona: ");
		lE.actualizarCompetidor(nombre, nuevoNombre);
		String nomEliminar = Util.introducirCadena("Introduce nombre de la persona: ");
		lE.eliminarCompetidor(nomEliminar);

		String nom = Util.introducirCadena("Introduce nombre de la persona: ");
		int part = Util.leerInt("Introduce numero de partidas: ");
		lE.registrarPartidas(nom, part);
		
		lE.listarPartidas();
		
		String nomComp = Util.introducirCadena("Introduce nombre de la persona: ");
		int partN = Util.leerInt("Introduce numero de partidas: ");
		lE.actualizarPartidas(nomComp, partN);
		
		String nomCompEl = Util.introducirCadena("Introduce nombre de la persona: ");
		lE.eliminarRegistro(nomCompEl);
	}
}
