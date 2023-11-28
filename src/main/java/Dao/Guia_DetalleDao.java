package Dao;

import java.util.List;

import Model.Guia_Detalle;

public interface Guia_DetalleDao {
	
	public List<Guia_Detalle> listarGuiaDetalle();
	
	public List<Guia_Detalle> listarDetalleGuiaPorIdGuia(int idGuia);
	
	public void agregarDetalleGuia(Guia_Detalle detalleguia);
	
}
