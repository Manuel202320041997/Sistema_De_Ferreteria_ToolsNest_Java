package Dao;

import Model.Guia;

public interface GuiaDao {
	
	public int agregarGuia(Guia guia);
	
	public String obtenerUltimoNumeroGuia();
	
	public void actualizarNumeroGuia(String nuevoNumeroGuia);
	
	public int obtenerIdGuiaPorNumeroGuia(String numeroGuia);	
	
	public Guia obtenerGuiaPorId(int idGuia);
}
