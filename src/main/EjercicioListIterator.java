package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class EjercicioListIterator {

	public static void main(String[] args) {
		// EJERCICIO ITERATOR
		ArrayList<String> alumnos = new ArrayList<>();
		alumnos.add("Ana");
		alumnos.add("Luis");
		alumnos.add("Marta");
		alumnos.add("Juan");
		alumnos.add("Pedro");

		Iterator<String> i = alumnos.iterator();
		System.out.println("--- Lista original ---");
		while (i.hasNext()) {
			String valor = i.next();
			System.out.println(valor);
		}

		i = alumnos.iterator();
		while (i.hasNext()) {
			String valor = i.next();
			if (valor.length() < 4) {
				i.remove();
			}
		}

		System.out.println("-------------");
		System.out.println(alumnos);

		// FIN EJERCICIO ITERATOR

		// EJERCICIO LISTITERATOR
		/*
		 * 1. Crea un ListIterator para recorrer la lista resultante. 2. Recorre la
		 * lista hacia delante: a. Si el nombre empieza con “P”, cámbialo a mayúsculas
		 * b. Si el nombre empieza con “M”, añade al iterador un nuevo nombre "Marcos"
		 * justo después 3. Imprime la lista después de estas modificaciones. 4. Recorre
		 * la lista hacia atrás e imprime todos los nombres.
		 */

		System.out.println("-------------");
		ListIterator<String> lI = alumnos.listIterator();
		while (lI.hasNext()) {
			String valor = lI.next();
			System.out.println(valor);
		}
		while (lI.hasNext()) {
			String valor = lI.next();
			System.out.println(valor);
			if (valor.charAt(0) == 'p' || valor.charAt(0) == 'P') {
				lI.set(valor.toUpperCase());
			}
			if (valor.charAt(0) == 'm' || valor.charAt(0) == 'M') {
				lI.set("Marcos");
			}

		}
		System.out.println("-------------");
		alumnos.listIterator();
		while (lI.hasPrevious()) {
			String valor = lI.previous();
			System.out.println(valor);
		}
	}
}