package Controller;

import java.util.List;

import Dao.RolDao;
import DaoImpl.RolDaoImpl;
import Model.Rol;

public class RolController {
	private RolDao roldao = null;
	
	public RolController() {
		roldao = new RolDaoImpl();
	}
	
	
	public List<Rol> listarRol(){
		List<Rol> listaRol = null;
		listaRol = roldao.listarRol();
		return listaRol;
	}
	
	public String obtenerNombreRolPorId(int idRol) {
		try {
			String nombreRol = roldao.obtenerNombreRolPorId(idRol);
			
			if(nombreRol != null) {
				return nombreRol;
			}
			else {
				System.err.println("El Rol no ha sido encontrado en la base de datos");
				return null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int ObtenerIdRolPorNombre(String nombreRol) {
		try {
			int idrol = roldao.obtenerIdRolPorNombre(nombreRol);
			
			if(idrol != 0) {
				return idrol;
			}
			else {
				System.err.println("El Rol no ha podido ser encontrado");
				return -1;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("ERROR AL OBTENER EL ID DEL ROL");
			return -1;
		}
	}
}
