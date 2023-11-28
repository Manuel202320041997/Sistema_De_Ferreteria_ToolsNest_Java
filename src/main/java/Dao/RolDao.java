package Dao;
import java.util.List;

import Model.Rol;

public interface RolDao {
	public List<Rol> listarRol();
	
	public int obtenerIdRolPorNombre(String nombreRol);
	
	public String obtenerNombreRolPorId(int idRol);
}
