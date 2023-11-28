package Dao;

import java.util.List;

import Model.MetodoPago;

public interface MetodoPagoDao {
	public List<MetodoPago> listarMetodoPago();
	
	public int obtenerIdMetodoPagoPorNombre(String nombreMetodoPago);
	
	public String obtenerNombreMetodoPagoPorId(int idMetodoPago);
}
