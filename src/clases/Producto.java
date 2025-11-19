package clases;

public class Producto {

	private int stock;
	private double precio;
	
	public Producto() {
		
	}

	public Producto(int stock, double precio) {
		super();
		this.stock = stock;
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [stock=" + stock + ", precio=" + precio + "]";
	}	
	
	
	
}
