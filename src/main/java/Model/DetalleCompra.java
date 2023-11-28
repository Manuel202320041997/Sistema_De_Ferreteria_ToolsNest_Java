package Model;

public class DetalleCompra {
	private int id;
	private int id_compra;
	private int id_producto;
	private int cantidad;
	private double precio_compra;
	private boolean estado;	
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_compra() {
		return id_compra;
	}
	
	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
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
	
	public double getPrecio_compra() {
		return precio_compra;
	}
	
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}	
}
