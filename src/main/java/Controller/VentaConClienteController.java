package Controller;

import java.util.List;

import DaoImpl.VentaConClienteDaoImpl;
import DaoImpl.VentaDaoImpl;
import Model.VentaConCliente;

public class VentaConClienteController {
	
	
	private VentaConClienteDaoImpl ventaConClienteDaoImpl = null;
	//private DetalleVentaDaoImpl detalleVentaDaoImpl = null; 
	
	public VentaConClienteController(){
		ventaConClienteDaoImpl = new VentaConClienteDaoImpl();
		
	}
	public List<VentaConCliente> listarVentasConCliente(){		
    	List<VentaConCliente> VentaConCliente = null;
    	VentaConCliente = ventaConClienteDaoImpl.listarVentasConCliente();
    	return VentaConCliente;
}
}
