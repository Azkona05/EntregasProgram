package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class EjercicioListIterator {

	public static void main(String[] args) {
		ArrayList<String> alumnos = new ArrayList<>();
		alumnos.add("Ana");
		alumnos.add("Luis");
		alumnos.add("Marta");
		alumnos.add("Juan");
		alumnos.add("Pedro");

		Iterator<String> i = alumnos.iterator();
		while (i.hasNext()) {
			String valor = i.next();
			if (valor.length() < 4) {
				i.remove();
			}
		}

		System.out.println("--- Lista tras eliminar nombres cortos ---");
		System.out.println(alumnos); // Quedan: Luis, Marta, Juan, Pedro

		// --- PARTE 2: LISTITERATOR ---
		/*
		 * Requisitos: 1. Recorrer hacia delante imprimiendo el índice (nextIndex). 2.
		 * Si empieza por P -> Mayúsculas (set). 3. Si empieza por M -> Añadir Marcos
		 * detrás (add).
		 */

		System.out.println("\n--- Recorrido hacia DELANTE (Modificando) ---");
		ListIterator<String> lI = alumnos.listIterator();

		while (lI.hasNext()) {
			System.out.print("Índice " + lI.nextIndex() + ": ");

			String valor = lI.next();
			System.out.println(valor);

			if (valor.toUpperCase().startsWith("P")) {
				lI.set(valor.toUpperCase()); 
			}
			if (valor.toUpperCase().startsWith("M")) {
				lI.add("Marcos"); 
			}
		}

		System.out.println("\n--- Estado actual de la lista ---");
		System.out.println(alumnos);
		System.out.println("\n--- Recorrido hacia ATRÁS ---");
		while (lI.hasPrevious()) {
			System.out.print("Índice " + lI.previousIndex() + ": ");

			String valor = lI.previous();
			System.out.println(valor);
		}
	}
}