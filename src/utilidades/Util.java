package utilidades;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Util {
	// Utilidad para leer cadenas
	public static String introducirCadena(String mensaje) {
		Scanner sc = new Scanner(System.in);

		String cadena = "";
		System.out.println(mensaje);

		try {
			cadena = sc.next();
		} catch (NoSuchElementException er) {
			System.out.println("Error al introducir datos");
			System.exit(0);
		}
		// sc.close();
		return cadena;
	}

	// Utilidad para leer un real
	public static float leerFloat(String message) {
		float n = 0;
		boolean ok;

		do {
			try {
				ok = true;
				n = Float.parseFloat(introducirCadena(message));
			} catch (NumberFormatException e) {
				System.out.println("Formato incorrecto, intentalo otra vez: ");
				ok = false;
			}
		} while (!ok);

		return n;
	}

	// Utilidad para leer un entero
	public static int leerInt(String message) {
		int n = -1;
		boolean ok;

		do {
			try {
				ok = true;
				n = Integer.parseInt(introducirCadena(message));
			} catch (NumberFormatException e) {
				System.out.println("No has introducido un entero, intentalo otra vez: ");
				ok = false;
			}
		} while (!ok);

		return n;
	}

	public static char leerChar(String message) {
		boolean error = false;
		String letra;

		do {
			error = false;
			letra = introducirCadena(message);
			if (letra.length() != 1) {
				System.out.println("Error, introduce un caracter: ");
				error = true;
			}

		} while (error);
		return letra.toUpperCase().charAt(0);
	}

	public static boolean leerRespuesta(String message) {
		String respu;
		do {
			respu = introducirCadena(message).toLowerCase();
		} while (!respu.equals("0") && !respu.equals("1") && !respu.equals("si") && !respu.equals("no")
				&& !respu.equals("s") && !respu.equals("n") && !respu.equals("true") && !respu.equals("false"));
		if (respu.equals("1") || respu.equals("si") || respu.equals("s") || respu.equals("true")) {
			return true;
		} else {
			return false;
		}
	}
}
