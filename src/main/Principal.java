package main;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import clases.Alumno;
import clases.Ciclo;
import utilidades.Util;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		char opc;
		do {
			opc = menu();
			opc = Character.toLowerCase(opc);
			if (alumnos.isEmpty() && opc != 'a' && opc != 'g') {
				System.out.println("¡AVISO! No hay alumnos registrados. Usa la opción a.");
				continue;
			}
			switch (opc) {
			case 'a':
				matricularAlumnos(alumnos);
				break;
			case 'b':
				mostrar(alumnos);
				break;
			case 'c':
				mostrarAlumno(alumnos);
				break;
			case 'd':
				modificarDatos(alumnos);
				break;
			case 'e':
				modificarCampoRepetidorConEdadDeterminada(alumnos);
				break;
			case 'f':
				bajaAlumno(alumnos);
				break;
			case 'g':
				System.out.println("Has salido. ");
				break;
			}
		} while (opc != 'g');
	}

	private static void matricularAlumnos(ArrayList<Alumno> alumnos) {
		boolean respuesta = true, ok = false;
		Ciclo c = null;

		do {
			System.out.println("--- NUEVA MATRÍCULA ---");
			String nif = Util.introducirCadena("Introduce el NIF del alumno: ");
			int contadorMatriculas = 0;
			Alumno alumnoExistente = null;
			for (Alumno a : alumnos) {
				if (a.getNif().equalsIgnoreCase(nif)) {
					contadorMatriculas++;
					alumnoExistente = a;
				}
			}
			if (contadorMatriculas >= 2) {
				System.out.println("AVISO: El alumno con NIF " + nif + " ya está matriculado en DAM y DAW.");

			} else if (contadorMatriculas == 1) {
				System.out.println("El alumno ya está matriculado en " + alumnoExistente.getCiclo());
				Ciclo cicloNuevo;
				if (alumnoExistente.getCiclo() == Ciclo.DAM) {
					cicloNuevo = Ciclo.DAW;
				} else {
					cicloNuevo = Ciclo.DAM;
				}
				System.out.println("Se procederá a matricular en: " + cicloNuevo);
				boolean repetidor = Util.leerRespuesta("¿Es repetidor en " + cicloNuevo + "? (si/no): ");
				if (repetidor == true) {
					Alumno nuevaMatricula = new Alumno(nif, alumnoExistente.getNombre(), alumnoExistente.getFecha(),
							cicloNuevo, repetidor);
					alumnos.add(nuevaMatricula);
					System.out.println("Matrícula realizada con éxito.");
				}
			} else {
				System.out.println("Alumno nuevo. Introduce los datos:");
				String nom = Util.introducirCadena("Nombre");
				LocalDate fecha = Util.pidoFechaDMA("Introduce fecha nacimiento: ");
				do {
					try {
						c = Ciclo.valueOf(Util.introducirCadena("Ciclo: ").toUpperCase());
						ok = true;
					} catch (IllegalArgumentException e) {
						System.out.println("Valor incorrecto, el ciclo debe de ser DAM o DAW");
					}
				} while (ok != true);
				boolean rep = Util.leerRespuesta("¿Es repetidor?");

				Alumno nuevo = new Alumno(nif, nom, fecha, c, rep);
				alumnos.add(nuevo);
				System.out.println("Alumno nuevo registrado.");
			}

			String seguir = Util.introducirCadena("¿Quieres seguir introduciendo alumnos? (si/no): ");
			respuesta = seguir.equalsIgnoreCase("si");

		} while (respuesta);
	}

	private static void mostrar(ArrayList<Alumno> alumnos) {
		for (Alumno al : alumnos) {
			System.out.println(al);
		}

	}

	private static void mostrarAlumno(ArrayList<Alumno> alumnos) {
		boolean encontrado = false;
		String nif = Util.introducirCadena("Introduce el DNI");
		for (Alumno al : alumnos) {
			if (al.getNif().equalsIgnoreCase(nif)) {
				encontrado = true;
				System.out.println(al);
			} else if (encontrado = false) {
				System.out.println("Alumno no encontrado. ");
			}
		}
	}

	private static void modificarDatos(ArrayList<Alumno> alumnos) {
		boolean encontrado = false;
		String nif = Util.introducirCadena("Introduzca el nif del alumno del que quiera modificar los datos: ");
		for (Alumno al : alumnos) {
			if (al.getNif().equalsIgnoreCase(nif)) {
				encontrado = true;
				al.setNombre(Util.introducirCadena("Introduzca nuevo nombre: "));
				al.setFecha(Util.pidoFechaDMA("Introduce la fecha de nacimiento "));
				al.setRepetidor(Util.leerRespuesta("Es repetidor? "));
			} else if (encontrado = false) {
				System.out.println("Alumno no encontrado.");
			}
		}
	}

	private static void modificarCampoRepetidorConEdadDeterminada(ArrayList<Alumno> alumnos) {
		System.out.println("--- MODIFICAR REPETIDORES (DAW) POR EDAD ---");
		int edadCorte = Util.leerInt("Introduce la edad a partir de la cual serán repetidores en DAW: ");
		int contadorModificados = 0;
		LocalDate ahora = LocalDate.now();
		for (Alumno a : alumnos) {
			if (a.getCiclo() == Ciclo.DAW) {
				int edadAlumno = Period.between(a.getFecha(), ahora).getYears();

				if (edadAlumno > edadCorte) {
					if (!a.isRepetidor()) {
						a.setRepetidor(true);
						System.out.println(
								"Alumno " + a.getNombre() + " (" + edadAlumno + " años) marcado como repetidor.");
						contadorModificados++;
					}
				}
			}
		}

		if (contadorModificados == 0) {
			System.out.println("No se encontraron alumnos de DAW que cumplan el criterio.");
		} else {
			System.out.println("Proceso finalizado. Se han modificado " + contadorModificados + " alumnos.");
		}
	}

	private static void bajaAlumno(ArrayList<Alumno> alumnos) {
		String nif = Util.introducirCadena("DNI a borrar");
		Alumno encontrado = null;
		for (Alumno al : alumnos) {
			if (al.getNif().equalsIgnoreCase(nif)) {
				encontrado = al;
				break;
			}
		}
		if (encontrado != null) {
			System.out.println("Vas a borrar a: " + encontrado.getNombre());
			if (Util.leerInt("Confirma: 1-Si, 0-No") == 1) {
				alumnos.removeIf(a -> a.getNif().equalsIgnoreCase(nif));
				System.out.println("Eliminado.");
			}
		} else {
			System.out.println("No encontrado.");
		}
	}

	private static char menu() {
		System.out.println("\n--- MENÚ DE GESTIÓN DE ALUMNOS ---");
		System.out.println("a. Matricular alumno/a/s");
		System.out.println("b. Listado de alumnos introducidos");
		System.out.println("c. Información de un alumno (por NIF)");
		System.out.println("d. Modificar datos de un alumno");
		System.out.println("e. Modificar repetidor (DAW por edad)");
		System.out.println("f. Dar de baja a un alumno");
		System.out.println("g. Salir");
		return Util.leerChar("Seleccione una opción: ");
	}
}
