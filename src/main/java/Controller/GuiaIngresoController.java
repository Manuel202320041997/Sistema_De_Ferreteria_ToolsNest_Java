package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Guia_Ingreso;
import DaoImpl.GuiaIngresoDaoImpl;
import Dao.Guia_IngresoDao;

public class GuiaIngresoController {
	private Guia_IngresoDao guiaingresodao = null;
	private GuiaController guiacontroller = null;
	
	public GuiaIngresoController() {
		guiaingresodao = new GuiaIngresoDaoImpl();
		guiacontroller = new GuiaController();
	}
	
	public List<Guia_Ingreso> listarGuiaIngreso(){
		List<Guia_Ingreso> listarGuiaIngreso = null;
		listarGuiaIngreso = guiaingresodao.listarGuiaIngreso();
		return listarGuiaIngreso;
	}
	
	public List<Guia_Ingreso> listarGuiaIngresoPorNumeroGuiaIngreso(String numeroGuiaIngreso){
	    List<Guia_Ingreso> listarGuiaIngreso = new ArrayList<>();

	    int idGuia = guiacontroller.obtenerIdGuiaPorNumeroGuia(numeroGuiaIngreso);

	    if (idGuia > 0) {
	    	listarGuiaIngreso = guiaingresodao.listarGuiaIngresoIdGuia(idGuia);
	    } else {
	        // Manejar el caso en que no se encontró la compra
	        System.err.println("ERROR: No se encontró la compra correspondiente al número " + numeroGuiaIngreso);
	        // Puedes lanzar una excepción aquí si prefieres
	    }

	    return listarGuiaIngreso;
	}
	
	public void registrarGuiaIngreso(Guia_Ingreso guiaingreso) {
		Guia_Ingreso detalle = new Guia_Ingreso();
		
		detalle.setId_guia(guiaingreso.getId_guia());
		detalle.setId_proveedor(guiaingreso.getId_proveedor());
		detalle.setId_transportista(guiaingreso.getId_transportista());
		detalle.setObservacion(guiaingreso.getObservacion());		
		
		guiaingresodao.agregarGuiaIngreso(detalle);
	}
}
