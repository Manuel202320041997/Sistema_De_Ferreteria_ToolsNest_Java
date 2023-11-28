package Controller;

import java.util.List;

import Dao.Guia_SalidaDao;
import DaoImpl.GuiaSalidaDaoImpl;
import Model.Guia_Ingreso;
import Model.Guia_Salida;

public class GuiaSalidaController {
	private GuiaController guiacontroller = null;
	private Guia_SalidaDao guiasalidadao = null;
	
	public GuiaSalidaController() {
		guiacontroller = new GuiaController();
		guiasalidadao = new GuiaSalidaDaoImpl();
	}
	
	public List<Guia_Salida> listarGuiaSalida (){
		List<Guia_Salida> listarGuiaSalida = null;
		listarGuiaSalida = guiasalidadao.listarGuiaSalida();
		return listarGuiaSalida;
	}
	
	public void registrarGuiaSalida(Guia_Salida guiasalida) {
		Guia_Salida detalle = new Guia_Salida();
		
		detalle.setId_guia(guiasalida.getId_guia());
		detalle.setDestinatario(guiasalida.getDestinatario());	
		
		guiasalidadao.agregarGuiaSalida(detalle);
	}
}
