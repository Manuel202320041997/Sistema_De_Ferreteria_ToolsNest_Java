package Controller;

import Dao.GuiaDao;
import DaoImpl.GuiaDaoImpl;
import Model.Compra;
import Model.Guia;

public class GuiaController {
	private GuiaDao guiadao = null;
	
	public GuiaController() {
		guiadao = new GuiaDaoImpl();
	}
	
	public String generarNumeroGuia() {
		String ultimoNumeroGuia = obtenerUltimoNumeroGuia();
		
		if(ultimoNumeroGuia != null) {
			char letraActual = ultimoNumeroGuia.charAt(0);
			int numeroActual = Integer.parseInt(ultimoNumeroGuia.substring(1));
			
			if(numeroActual < 999999) {
				numeroActual++;
			}
			else {
				numeroActual = 1;
				letraActual = (char) (letraActual + 1); // aumenta la letra en uno: A, B, C, D, E
			}
			
			String numeroGuia = letraActual + String.format("%06d", numeroActual);
			
			return numeroGuia;
		}
		else {
			return null;
		}
	}
	
	
	private String obtenerUltimoNumeroGuia() {
		return guiadao.obtenerUltimoNumeroGuia();
	}
	
	public int registrarGuia(String numeroGuia, int idEmpleado, String motivo) {
		Guia guia = new Guia();
		guia.setNumero_guia(numeroGuia);
		guia.setId_empleado(idEmpleado);
		guia.setMotivo(motivo);
		
		int idguia = guiadao.agregarGuia(guia);
		return idguia;
	}
	
	public int obtenerIdGuiaPorNumeroGuia(String numeroGuia) {
		return guiadao.obtenerIdGuiaPorNumeroGuia(numeroGuia);
	}
	
	public Guia obtenerGuiaPorId(int idGuia) {
		return guiadao.obtenerGuiaPorId(idGuia);
	}
	
}
