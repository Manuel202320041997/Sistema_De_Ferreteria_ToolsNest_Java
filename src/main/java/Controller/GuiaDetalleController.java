package Controller;

import java.util.ArrayList;
import java.util.List;

import Dao.Guia_DetalleDao;
import DaoImpl.GuiaDetalleDaoImpl;
import Model.Guia_Detalle;

public class GuiaDetalleController {
	private Guia_DetalleDao guiadetalledao = null;
	private GuiaController guiacontroller = null;
	
	public GuiaDetalleController() {
		guiadetalledao = new GuiaDetalleDaoImpl();
		guiacontroller = new GuiaController();
	}
	
	public List<Guia_Detalle> listarGuiaDetalle(){
		List<Guia_Detalle> listarGuiaDetalle = null;
		listarGuiaDetalle = guiadetalledao.listarGuiaDetalle();
		return listarGuiaDetalle;
	}
	
	public List<Guia_Detalle> listarDetalleGuiaPorNumeroGuia(String numeroGuia){
	    List<Guia_Detalle> listaDetalleGuia = new ArrayList<>();

	    int idGuia = guiacontroller.obtenerIdGuiaPorNumeroGuia(numeroGuia);

	    if (idGuia > 0) {
	    	listaDetalleGuia = guiadetalledao.listarDetalleGuiaPorIdGuia(idGuia);
	    } else {
	        // Manejar el caso en que no se encontró la compra
	        System.err.println("ERROR: No se encontró la compra correspondiente al número " + numeroGuia);
	        // Puedes lanzar una excepción aquí si prefieres
	    }

	    return listaDetalleGuia;
	}
	
	public void registrarDetalleGuia(Guia_Detalle guiadetalle) {
		Guia_Detalle detalle = new Guia_Detalle();
		
		detalle.setId_guia(guiadetalle.getId_guia());
		detalle.setId_producto(guiadetalle.getId_producto());
		detalle.setCantidad(guiadetalle.getCantidad());
		
		guiadetalledao.agregarDetalleGuia(detalle);
	}
}
