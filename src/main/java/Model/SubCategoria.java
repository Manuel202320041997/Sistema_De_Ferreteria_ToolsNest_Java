package Model;

public class SubCategoria {
	private int id;
	private String descripcion;
	private int id_categoria;
	private boolean estado;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getId_categoria() {
		return id_categoria;
	}
	
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
