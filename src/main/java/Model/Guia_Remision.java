package Model;

public class Guia_Remision {
	private int id;
	private int id_guia;
	private String punto_partida;
	private String punto_llegada;
	private int id_transportista;
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
	
	public String getPunto_partida() {
		return punto_partida;
	}
	
	public void setPunto_partida(String punto_partida) {
		this.punto_partida = punto_partida;
	}
	
	public String getPunto_llegada() {
		return punto_llegada;
	}
	
	public void setPunto_llegada(String punto_llegada) {
		this.punto_llegada = punto_llegada;
	}
	
	public int getId_transportista() {
		return id_transportista;
	}
	
	public void setId_transportista(int id_transportista) {
		this.id_transportista = id_transportista;
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
