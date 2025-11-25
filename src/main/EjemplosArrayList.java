package main;

import java.util.ArrayList;
import java.util.Collections; // Import necesario para ordenar
import java.util.List;

public class EjemplosArrayList {
	public static void main(String[] args) {

		// 1. CONSTRUCTOR
		// Creamos el ArrayList. Notar que usamos el operador diamante <>
		ArrayList<String> inventario = new ArrayList<>();
		System.out.println("--- Inicio del Programa ---");

		// 2. MÉTODO ADD (Agregar elementos)
		// Agrega elementos al final de la lista
		inventario.add("Laptop");
		inventario.add("Mouse");
		inventario.add("Teclado");
		inventario.add("Monitor");
		System.out.println("Inventario inicial: " + inventario);
		// Creamos una lista temporal (una caja con nuevos productos)
		ArrayList<String> cajaNueva = new ArrayList<>();
		cajaNueva.add("Zapatos");
		cajaNueva.add("Gorra");
		cajaNueva.add("Bufanda");

		// 3. ADDALL: Añadimos TODO el contenido de la caja al inventario de golpe
		inventario.addAll(cajaNueva);
		System.out.println("Se ha añadido la caja nueva.");
		System.out.println("Inventario actualizado: " + inventario);
		
		// 4. MÉTODO ADD CON ÍNDICE (Insertar)
		// Inserta "Tablet" en la posición 1, desplazando a los demás a la derecha
		inventario.add(1, "Tablet");
		System.out.println("Después de insertar Tablet en pos 1: " + inventario);

		// 5. MÉTODO SET (Modificar/Actualizar)
		// Cambia el elemento en la posición 2 ("Mouse") por "Mouse Gaming"
		inventario.set(2, "Mouse Gaming");
		System.out.println("Después de actualizar el Mouse: " + inventario);

		// 6. MÉTODO GET (Obtener/Leer)
		// Recupera el elemento en una posición específica
		String producto = inventario.get(0);
		System.out.println("El primer producto es: " + producto);

		// 7. MÉTODO REMOVE (Eliminar)
		// a) Eliminar por índice (Borra el elemento en la posición 3 - Teclado)
		inventario.remove(3);
		// b) Eliminar por objeto (Busca "Monitor" y lo borra)
		inventario.remove("Monitor");
		System.out.println("Después de eliminar Teclado y Monitor: " + inventario);

		// 8. MÉTODO SIZE (Tamaño)
		// Devuelve la cantidad de elementos actuales
		System.out.println("Total de productos: " + inventario.size());

		// 9. MÉTODO CONTAINS (Verificar existencia)
		// Devuelve true si el elemento existe en la lista
		boolean tieneLaptop = inventario.contains("Laptop");
		System.out.println("¿Hay stock de Laptop?: " + (tieneLaptop ? "Sí" : "No"));

		// 10. MÉTODO INDEXOF (Buscar posición)
		// Devuelve el índice de la primera aparición del elemento, o -1 si no existe
		int posMouse = inventario.indexOf("Mouse Gaming");
		System.out.println("El Mouse Gaming está en el índice: " + posMouse);

		// 11. MÉTODO TOARRAY (Convertir a Arreglo estático)
		// Convierte el ArrayList en un Array simple de Java
		Object[] arrayEstatico = inventario.toArray();
		System.out.println("Copia en array estático creada.");

		// 12. MÉTODO IS_EMPTY (Verificar si está vacío)
		if (!inventario.isEmpty()) {
			System.out.println("La lista no está vacía.");
		}

		// 13. UTILIDAD: SORT (Ordenar)
		// Ordena la lista alfabéticamente (usa Collections.sort o list.sort)
		Collections.sort(inventario);
		System.out.println("Inventario ordenado A-Z: " + inventario);

		// 14. MÉTODO SUBLIST (Sublista)
		// Crea una vista de una parte de la lista (del índice 0 al 2, sin incluir el 2)
		List<String> topProductos = inventario.subList(0, 2);
		System.out.println("Top 2 productos (sublista): " + topProductos);

		// 15. MÉTODO CLEAR (Limpiar todo)
		// Elimina todos los elementos de la lista
		inventario.clear();
		System.out.println("Inventario después de clear(): " + inventario);
		System.out.println("¿Está vacía ahora?: " + inventario.isEmpty());
	}
}
