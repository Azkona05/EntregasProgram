package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class LigaEsports {

	private ArrayList<String> competidores;
	private HashMap<String, Integer> partidasGanadas;

	public ArrayList<String> getCompetidores() {
		return competidores;
	}

	public void setCompetidores(ArrayList<String> competidores) {
		this.competidores = competidores;
	}

	public HashMap<String, Integer> getPartidasGanadas() {
		return partidasGanadas;
	}

	public void setPartidasGanadas(HashMap<String, Integer> partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}

	public void añadirCompetidor(String nombre) {
		competidores.add(nombre);
	}

	public void listarCompetidores() {
		for (String n : competidores) {
			System.out.println(n);
		}
	}

	public void actualizarCompetidor(String antiguo, String nuevo) {
		int index = 0;
		index = buscarCompetidor(antiguo);
		if (index != -1) {
			competidores.set(index, nuevo);
		} else {
			System.out.println("Competidor no encontrado. ");
		}
	}

	public int buscarCompetidor(String nomAntiguo) {
		for (int i = 0; i < competidores.size(); i++) {
			if (competidores.get(i).equalsIgnoreCase(nomAntiguo)) {
				return i;
			}
		}
		return -1;
	}

	public void eliminarCompetidor(String nombre) {
		int index = 0;
		index = buscarCompetidor(nombre);
		if (index == 1) {
			competidores.remove(index);
		} else {
			System.out.println("Competidor no encontrado. ");
		}
	}

	public void registrarPartidas(String competidor, int cantidad) {
		partidasGanadas.put(competidor, cantidad);
	}

	public void listarPartidas() {
		for (Entry<String, Integer> entry : partidasGanadas.entrySet()) {
			String clave = entry.getKey();
			Integer valor = entry.getValue();
			System.out.println("Clave: " + clave + ", Valor: " + valor);
		}
	}

	public void actualizarPartidas(String competidor, int nuevasPartidas) {
		int index = buscarCompetidor(competidor);
		if (index != -1) {
			if (partidasGanadas.containsKey(competidor)) {
				partidasGanadas.remove(competidor);
				partidasGanadas.put(competidor, nuevasPartidas);
			}
		} else {
			System.out.println("Competidor no encontrado.");
		}
	}

	public void eliminarRegistro(String competidor) {
		int index = 0;
		index = buscarCompetidor(competidor);
		if (index == 1) {
			if (partidasGanadas.containsKey(competidor)) {
				partidasGanadas.remove(competidor);
			}
		} else {
			System.out.println("Competidor no encontrado. ");
		}
	}

	public boolean compararRegistros() {
		Iterator<String> itLista = competidores.iterator();
		Iterator<String> itMapa = partidasGanadas.keySet().iterator();
		while (itLista.hasNext()) {
			String nombreJugador = itLista.next();
			if (!partidasGanadas.containsKey(nombreJugador)) {
				return false;
			}
		}
		return true;
	}
}
