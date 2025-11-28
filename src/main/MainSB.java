package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import clases.Bibliotecario;
import clases.PersonaSB;
import clases.Socio;
import utilidades.Util;

public class MainSB {

	public static void main(String[] args) {
		ArrayList<PersonaSB> socios = new ArrayList<>();
		int opc = 0;
		do {
			opc = menu();
			switch (opc) {
			case 0:
				alta(socios);
				break;
			case 1:
				mostrar(socios);
				break;
			case 2:
				mostrarBibliotecarios(socios);
				break;
			case 3:
				mostrarBibliotecariosPorSeccion(socios);
				break;
			case 4:
				buscarPorNombre(socios);
				break;
			case 5:
				filtrarSociosPorCuotaMensual(socios);
				break;
			case 6:
				filtrarSociosPorAntiguedad(socios);
				break;
			case 7:
				baja(socios);
				break;
			case 8:
				System.out.println("Has salido. ");
				break;
			default:
				System.err.println("ERROR! Opcion incorrecta. ");
				break;
			}
		} while (opc != 8);
	}

	private static void alta(ArrayList<PersonaSB> socios) {
		System.out.println("--- ALTA NUEVO MIEMBRO ---");
		String dni = Util.introducirCadena("Introduce el DNI: ");
		if (existeDni(socios, dni)) {
			System.err.println("ERROR: Ya existe un socio con el DNI " + dni);
		}
		System.out.println("¿Qué deseas dar de alta?");
		System.out.println("1. Socio normal");
		System.out.println("2. Bibliotecario");
		int tipo = Util.leerInt("Elige una opción: ");

		Socio nuevoSocio;

		if (tipo == 2) {
			nuevoSocio = new Bibliotecario();
		} else {
			nuevoSocio = new Socio();
		}
		nuevoSocio.setDatos(dni);
		socios.add(nuevoSocio);

		System.out.println("¡Alta realizada con éxito!");
	}

	private static boolean existeDni(ArrayList<PersonaSB> socios, String dni) {
		for (PersonaSB s : socios) {
			if (s.getDni().equalsIgnoreCase(dni)) {
				return true;
			}
		}
		return false;
	}

	private static void mostrar(ArrayList<PersonaSB> socios) {
		for (PersonaSB s : socios) {
			System.out.println(s);
		}

	}

	private static void mostrarBibliotecarios(ArrayList<PersonaSB> socios) {
		for (PersonaSB s : socios) {
			if (s instanceof Bibliotecario) {
				Bibliotecario b = (Bibliotecario) s;
				System.out.println("- " + b);
			}
		}
	}

	private static void mostrarBibliotecariosPorSeccion(ArrayList<PersonaSB> socios) {
		System.out.println("--- BÚSQUEDA POR SECCIÓN ---");
		String seccionBusqueda = Util.introducirCadena("Introduce la sección a buscar: ");
		boolean encontrado = false;
		for (PersonaSB s : socios) {
			if (s instanceof Bibliotecario) {
				Bibliotecario b = (Bibliotecario) s;
				if (b.getSeccion().equalsIgnoreCase(seccionBusqueda)) {
					if (!encontrado) {
						System.out.println("Bibliotecario/s de la sección " + seccionBusqueda.toUpperCase() + ":");
						encontrado = true;
					}
					System.out.println("- " + b.getNombreCompleto());
				}
			}
		}
		if (!encontrado) {
			System.out.println("No hay bibliotecarios en la sección " + seccionBusqueda);
		}
	}

	private static void buscarPorNombre(ArrayList<PersonaSB> socios) {
		System.out.println("--- BUSCAR POR NOMBRE ---");
		String busqueda = Util.introducirCadena("Introduce el nombre o parte del nombre: ").toLowerCase();
		boolean encontrado = false;
		for (PersonaSB s : socios) {
			if (s.getNombreCompleto().toLowerCase().contains(busqueda)) {
				int antiguedad = LocalDate.now().getYear() - ((Socio) s).getAnioAlta();
				String cargo = (s instanceof Bibliotecario) ? "Sí (Bibliotecario)" : "No (Socio)";
				System.out.println("--------------------------------");
				System.out.println("Nombre: " + s.getNombreCompleto());
				System.out.println("DNI: " + s.getDni());
				System.out.println("Años en la biblioteca: " + antiguedad);
				System.out.println("¿Es bibliotecario?: " + cargo);
				System.out.println("--------------------------------");
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("ERROR: No se encontraron coincidencias para: " + busqueda);
		}
	}

	private static void filtrarSociosPorCuotaMensual(ArrayList<PersonaSB> socios) {
		System.out.println("--- FILTRAR POR CUOTA ---");
		float cuotaMinima = (float) Util.leerInt("Introduce la cuota mínima a buscar: ");

		boolean encontrado = false;

		for (PersonaSB s : socios) {
			float cuotaReal = ((Socio) s).calcularCuotaFinal();

			if (cuotaReal >= cuotaMinima) {
				System.out.print("Socio: " + s.getNombreCompleto() + " | Cuota Final: " + cuotaReal + "€");
				if (s instanceof Bibliotecario) {
					System.out.print(" [Es Bibliotecario]");
				}
				encontrado = true;
			}
		}

		if (!encontrado) {
			System.out.println("No hay socios con una cuota superior o igual a " + cuotaMinima);
		}

	}

	private static void filtrarSociosPorAntiguedad(ArrayList<PersonaSB> socios) {
		System.out.println("--- BIBLIOTECARIOS POR ANTIGÜEDAD ---");
		int aniosMinimos = Util.leerInt("Introduce el nº de años mínimos: ");
		int anioActual = LocalDate.now().getYear();
		boolean encontrado = false;
		for (PersonaSB s : socios) {
			if (s instanceof Bibliotecario) {
				int antiguedad = anioActual - ((Socio) s).getAnioAlta();

				if (antiguedad >= aniosMinimos) {
					System.out.println("- " + s.getNombreCompleto() + " (Antigüedad: " + antiguedad + " años)");
					encontrado = true;
				}
			}
		}
		if (!encontrado) {
			System.out.println("No hay bibliotecarios con " + aniosMinimos + " años o más.");
		}
	}

	private static void baja(ArrayList<PersonaSB> socios) {
		String dni = Util.introducirCadena("DNI a borrar");
		boolean encontrado = false;
		Iterator<PersonaSB> it = (Iterator<PersonaSB>) socios.iterator();
		while (it.hasNext()) {
			PersonaSB a = it.next();
			if (a.getDni().equalsIgnoreCase(dni)) {
				it.remove();
				encontrado = true;
			}
		}
		if (encontrado == false) {
			System.out.println("Socio no encontrado. ");
		} else {
			System.out.println("Socio eliminado correctamente. ");
		}
	}

	private static int menu() {
		System.out.println("\n-----------------------------------------------------");
		System.out.println("           GESTIÓN DE LA BIBLIOTECA");
		System.out.println("-----------------------------------------------------");
		System.out.println("0. Introducir datos de socios/bibliotecarios (Nuevo ingreso).");
		System.out.println("1. Visualizar todos los datos de los socios (incl. bibliotecarios).");
		System.out.println("2. Visualizar únicamente los bibliotecarios.");
		System.out.println("3. Visualizar bibliotecarios de una sección concreta.");
		System.out.println("4. Buscar por nombre (Ver DNI, Antigüedad y Cargo).");
		System.out.println("5. Filtrar socios por cuota mensual (>= valor).");
		System.out.println("6. Filtrar bibliotecarios por años de antigüedad.");
		System.out.println("7. Dar de baja a un socio/bibliotecario (por DNI).");
		System.out.println("8. Salir.");
		System.out.println("-----------------------------------------------------");
		return Util.leerInt("Elige una opcion: ");
	}
}
