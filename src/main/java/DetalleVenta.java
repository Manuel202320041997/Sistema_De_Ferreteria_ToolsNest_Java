package Model;

public class DetalleVenta {
	private int id;
	private int id_venta;
	private int id_producto;
	private int cantidad;
	private double precio_venta;
	private String FechaVenta;
	
	
    public DetalleVenta(int id_venta, int idProducto, int cantidad, double precio_venta) {
        this.id_venta = id_venta;
    	this.id_producto = idProducto;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
    }

	public DetalleVenta(int idProducto, int cantidad2, double precio_venta2) {
		this.id_producto = idProducto;
        this.cantidad = cantidad2;
        this.precio_venta = precio_venta2;
    }

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public String getFechaVenta() {
		return FechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		FechaVenta = fechaVenta;
	}

	@Override
	public String toString() {
		return "Venta [id_venta=" + id_venta + ", id_producto=" + id_producto + ", cantidad=" + cantidad
				+ ", precio_venta=" + precio_venta + ", FechaVenta=" + FechaVenta + "]";
	}
	
	
}
