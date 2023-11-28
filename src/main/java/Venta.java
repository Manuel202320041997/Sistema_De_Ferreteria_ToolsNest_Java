package Model;

public class Venta {
		
	private int id;
	private String numero_venta;
	private double total;
	private int id_cliente;
	private int id_modo_pago;
	private int id_empleado;

	/*
	public Venta() {
		this.id = 0;
		this.id_cliente = 0;
		this.valorPagar = 0.0;
		this.FechaVenta = "";
		this.estado = 0;
		
	}

	public Venta(int id_venta, int id_cliente, double valorPagar, String fechaVenta, int estado) {
		super();
		this.id_venta = id_venta;
		this.id_cliente = id_cliente;
		this.valorPagar = valorPagar;
		FechaVenta = fechaVenta;
		this.estado = estado;
	}
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero_venta() {
		return numero_venta;
	}

	public void setNumero_venta(String numero_venta) {
		this.numero_venta = numero_venta;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
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

	
	
}	
