package Model;

public class Contrato {
	
	private int id;
	private int id_empleado;
	private double sueldo_mensual;
	private double gratificacion;	
	private double cts;
	private String fecha_registro;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_empleado() {
		return id_empleado;
	}
	
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	
	
	public double getSueldo_mensual() {
		return sueldo_mensual;
	}
	
	public void setSueldo_mensual(double sueldo_mensual) {
		this.sueldo_mensual = sueldo_mensual;
	}
	
	public double getGratificacion() {
		return gratificacion;
	}
	
	public void setGratificacion(double gratificacion) {
		this.gratificacion = gratificacion;
	}
	
	public double getCts() {
		return cts;
	}
	
	public void setCts(double cts) {
		this.cts = cts;
	}
	
	public String getFecha_registro() {
		return fecha_registro;
	}
	
	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
}
