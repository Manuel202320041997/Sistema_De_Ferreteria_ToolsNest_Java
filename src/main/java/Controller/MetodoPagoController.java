package Controller;

import java.util.List;

import Dao.MetodoPagoDao;
import DaoImpl.MetodoPagoDaoImpl;
import Model.MetodoPago;


public class MetodoPagoController {
	
	private MetodoPagoDao metodopagodao = null;
	
	public MetodoPagoController() {
		metodopagodao = new MetodoPagoDaoImpl();
	}

	public List<MetodoPago> listarMetodoPago(){
		List<MetodoPago> listaMetodoPago = null;
		listaMetodoPago = metodopagodao.listarMetodoPago();
		return listaMetodoPago;
	}
	
	public int obtenerIdMetodoPagoPorNombre(String nombreMetodoPago) {
		int id = metodopagodao.obtenerIdMetodoPagoPorNombre(nombreMetodoPago);
		if (id <= 0) {
	        System.err.println("No se ha encontrado el ID DEL METODO DE PAGO CONTROLLER");
	    }

	    return id;
	}
	
	public String obtenerNombreMetodoPagoPorId(int idMetodoPago) {
		return metodopagodao.obtenerNombreMetodoPagoPorId(idMetodoPago);
	}
	
}
