package Model;

public class Guia_Ingreso {
	private int id;
	private int id_guia;
	private int id_proveedor;
	private int id_transportista;
	private String observacion;
	private boolean estado;
	private String fecha_registro;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_guia() {
		return id_guia;
	}
	
	public void setId_guia(int id_guia) {
		this.id_guia = id_guia;
	}
	
	public int getId_proveedor() {
		return id_proveedor;
	}
	
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	
	public int getId_transportista() {
		return id_transportista;
	}
	
	public void setId_transportista(int id_transportista) {
		this.id_transportista = id_transportista;
	}
	
	public String getObservacion() {
		return observacion;
	}
	
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
}
