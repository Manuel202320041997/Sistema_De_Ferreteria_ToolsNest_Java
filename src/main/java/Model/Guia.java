package Model;

public class Guia {
	private int id;
	private String numero_guia;
	private int id_empleado;
	private String motivo;
	private boolean estado;
	private String fecha_registro;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNumero_guia() {
		return numero_guia;
	}
	
	public void setNumero_guia(String numero_guia) {
		this.numero_guia = numero_guia;
	}
	
	public int getId_empleado() {
		return id_empleado;
	}
	
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
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
