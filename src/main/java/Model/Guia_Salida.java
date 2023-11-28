package Model;

public class Guia_Salida {
	private int id;
	private int id_guia;
	private String destinatario;
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
	
	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
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
