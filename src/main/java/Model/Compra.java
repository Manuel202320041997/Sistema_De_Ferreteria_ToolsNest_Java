package Model;

public class Compra {
	private int id;
	private String numero_compra;
	private int id_proveedor;
	private double total;
	private int id_modo_pago;
	private int id_empleado;
	private boolean estado;
	private String fecha_compra;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNumero_compra() {
		return numero_compra;
	}
	
	public void setNumero_compra(String numero_compra) {
		this.numero_compra = numero_compra;
	}
	
	public int getId_proveedor() {
		return id_proveedor;
	}
	
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public int getId_modo_pago() {
		return id_modo_pago;
	}
	
	public void setId_modo_pago(int id_modo_pago) {
		this.id_modo_pago = id_modo_pago;
	}
	
	public int getId_empleado() {
		return id_empleado;
	}
	
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(String fecha_compra) {
		this.fecha_compra = fecha_compra;
	}		
	
}
