package main;

import clases.Bicicleta;
import clases.Coche;
import clases.Patinete;
import clases.Vehiculo;

public class PrincipalEjercicioHerencia {

	public static void main(String[] args) {
		Vehiculo[] vehiculos = { new Coche("Audi", "A3", (float) 15.50, 4, false),
				new Patinete("Xiaomi", "a", (float) 5.5, 20), new Bicicleta("aaa", "bbb", (float) 2.5, "Disco") };

		for (Vehiculo v : vehiculos) {
			System.out.println(v);
		}
	}
}
