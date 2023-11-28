package Model;

public class Transportista {
	
	private int id;
	private int dni;
	private String nombres;
	private String placa_vehiculo;
	private String modelo_vehiculo;
	private String brevete;
	private boolean estado;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getPlaca_vehiculo() {
		return placa_vehiculo;
	}
	
	public void setPlaca_vehiculo(String placa_vehiculo) {
		this.placa_vehiculo = placa_vehiculo;
	}
	
	public String getModelo_vehiculo() {
		return modelo_vehiculo;
	}
	
	public void setModelo_vehiculo(String modelo_vehiculo) {
		this.modelo_vehiculo = modelo_vehiculo;
	}
	
	public String getBrevete() {
		return brevete;
	}
	
	public void setBrevete(String brevete) {
		this.brevete = brevete;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}	
}
