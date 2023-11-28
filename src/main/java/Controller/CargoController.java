package Controller;

import java.util.List;
import Dao.CargoDao;
import DaoImpl.CargoDaoImpl;
import Model.Cargo;


public class CargoController {
private CargoDao cargodao = null;
	
	public CargoController() {
		cargodao = new CargoDaoImpl();
	}
	
	
	public List<Cargo> listarCargo(){
		List<Cargo> listaCargo = null;
		listaCargo = cargodao.listarCargo();
		return listaCargo;
	}
	
	public String obtenerNombreCargoPorId(int idCargo) {
		try {
			String nombreCargo = cargodao.obtenerNombreCargoPorId(idCargo);
			
			if(nombreCargo != null) {
				return nombreCargo;
			}
			else {
				System.err.println("El Cargo no ha sido encontrado en la base de datos");
				return null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int ObtenerIdCargoPorNombre(String nombreCargo) {
		try {
			int idcargo = cargodao.obtenerIdCargoPorNombre(nombreCargo);
			
			if(idcargo != 0) {
				return idcargo;
			}
			else {
				System.err.println("El Cargo no ha podido ser encontrado");
				return -1;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("ERROR AL OBTENER EL ID DEL CARGO");
			return -1;
		}
	}
}
