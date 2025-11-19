package main;

import clases.Producto;

public class Main {

	public static void main(String[] args) {
//		Producto[] inventario = new Producto[25];
		Producto[] inventario = { new Producto(22, 30.5), new Producto(123, 36.9), new Producto(234, 23.6), null,
				new Producto(125, 23.6) };
//		Random r = new Random();
		int numMin = 0, numMax = 100;
		double total = 0;

//		for (int i = 0; i < inventario.length; i++) {
//			int stock = r.nextInt(numMin, numMax + 1);
//			double precio = r.nextDouble(numMin, numMax);
//			inventario[i] = new Producto(stock, precio);
//		}

		for (int i = 0; i < inventario.length; i++) {
			if (inventario[i] != null && inventario[i].getStock() % 2 == 0) {
				System.out.println("---");
			} else if (inventario[i] != null) {
				total += inventario[i].getPrecio();
			}
		}

		for (Producto p : inventario) {
			System.out.println(p);
		}
		System.out.println("Total de precios con stock impar: " + total);
		double max = 0;
		Producto p = null;

		for (int i = 0; i < inventario.length; i++) {
			if (inventario[i] != null && inventario[i].getStock() > 5) {
				if (inventario[i] != null && inventario[i].getPrecio() > max) {
					max = inventario[i].getPrecio();
					p = inventario[i];
				}
			}
		}
		if (p != null) {
			System.out.println(p);
		}

		for (int i = 0; i < inventario.length; i++) {
			if (inventario[i] == null) {
				for (int j = i; j < inventario.length - 1; j++) {
					inventario[j] = inventario[j + 1];
				}
				inventario[inventario.length - 1] = null;
				break;
			}
			System.out.println(inventario[i]);
		}
	}
}
