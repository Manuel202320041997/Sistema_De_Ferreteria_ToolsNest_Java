package Dao;

import java.util.List;

import Model.DetalleVenta;
//import Model.Producto;


public interface DetalleVentaDao {
	public List<DetalleVenta> listarDetalleVenta();
	
	public List<DetalleVenta> listarDetalleVentaPorIdVenta(int idVenta);
	
	public void agregarDetalleVenta(DetalleVenta detalle);
}
