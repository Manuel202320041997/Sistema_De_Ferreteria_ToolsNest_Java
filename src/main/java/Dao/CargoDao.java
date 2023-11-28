package Dao;

import java.util.List;

import Model.Cargo;

public interface CargoDao {
public List<Cargo> listarCargo();
	
	public int obtenerIdCargoPorNombre(String nombreCargo);
	
	public String obtenerNombreCargoPorId(int idCargo);
}
