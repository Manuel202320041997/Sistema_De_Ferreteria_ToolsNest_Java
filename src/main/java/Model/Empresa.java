package Model;

public class Empresa {
	private int id;
	private String ruc;
	private String razon_social;
	private String telefono;
	private String direccion;
	private String logo_login;
	private String logo_inicio;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRuc() {
		return ruc;
	}
	
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	public String getRazon_social() {
		return razon_social;
	}
	
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getLogo_login() {
		return logo_login;
	}
	
	public void setLogo_login(String logo_login) {
		this.logo_login = logo_login;
	}
	
	public String getLogo_inicio() {
		return logo_inicio;
	}
	
	public void setLogo_inicio(String logo_inicio) {
		this.logo_inicio = logo_inicio;
	}	
}
