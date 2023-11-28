package Dao;

import java.util.List;

import Model.Proveedor;

public interface ProveedorDao {
	public List<Proveedor> listarProveedor();
	
	public void agregarProveedor(Proveedor proveedor);
	
	public void eliminarProveedor(int idProveedor);
	
	public void editarProveedor(Proveedor proveedor);
	
	public Proveedor buscarProveeedorPorId(int idProveedor);
	
	public int buscarIdProveedorPorNombre(String nombreProveedor);
	
	public void CambiarEstadoInactivo(int id);
	
	public void CambiarEstadoActivo(int id);
}
