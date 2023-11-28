package Model;

public class Correo {
	private String correoEnviar;
	private String correoRecibir;
	private String clave;
	private String para;
	private String asunto;
	private String contenido;
	private String tipoContenido;
		
	public String getCorreoEnviar() {
		return correoEnviar;
	}


	public void setCorreoEnviar(String correoEnviar) {
		this.correoEnviar = correoEnviar;
	}


	public String getCorreoRecibir() {
		return correoRecibir;
	}


	public void setCorreoRecibir(String correoRecibir) {
		this.correoRecibir = correoRecibir;
	}


	public String getclave() {
		return clave;
	}
	
	public void setclave(String clave) {
		this.clave = clave;
	}
	
	public String getPara() {
		return para;
	}
	
	public void setPara(String para) {
		this.para = para;
	}
	
	public String getAsunto() {
		return asunto;
	}
	
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getTipoContenido() {
		return tipoContenido;
	}


	public void setTipoContenido(String tipoContenido) {
		this.tipoContenido = tipoContenido;
	}	
}
