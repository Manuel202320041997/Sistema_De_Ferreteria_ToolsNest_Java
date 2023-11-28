package Dao;

import java.util.List;

import Model.Compra;

public interface CompraDao {	
	
	public List<Compra> listarCompras();
	
	public int agregarOrdenCompra(Compra compra);
	
	public String obtenerUltimoNumeroCompra();
	
	public void actualizarNumeroCompra(String nuevoNumeroCompra);
	
	public int obtenerIdCompraPorNumeroCompra(String numeroCompra);	
}