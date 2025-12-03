package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import clases.Cargo;
import clases.Cliente;
import clases.Entrenamiento;
import clases.Persona;
import clases.Trabajador;

public class MainEntrenamientos {

	public static void main(String[] args) {
		Map<String, Entrenamiento> entrenamientos = new HashMap<>();
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Entrenamiento ent;
		Persona p;

		ent = new Entrenamiento(LocalDate.now(), "Sentadillas", 100);
		entrenamientos.put(ent.getCodigo(), ent);
		ent = new Entrenamiento(LocalDate.now(), "Flexiones", 200);
		entrenamientos.put(ent.getCodigo(), ent);
		ent = new Entrenamiento(LocalDate.now(), "Abdominales", 500);
		entrenamientos.put(ent.getCodigo(), ent);
		p = new Cliente("160654812A", "Pedro", LocalDate.now(), (HashMap<String, Entrenamiento>) entrenamientos);
		personas.add(p);
		p = new Trabajador("65432173A", "Sandra", "usuarioS", "1234", Cargo.MONITOR);
		personas.add(p);
		
		for (Persona per : personas) {
			System.out.println(per);
		}
	}
}