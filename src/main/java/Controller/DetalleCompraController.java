package Controller;

import java.util.ArrayList;
import java.util.List;

import Dao.DetalleCompraDao;
import DaoImpl.DetalleCompraDaoImpl;
import Model.Compra;
import Model.DetalleCompra;

public class DetalleCompraController {
	private DetalleCompraDao detallecompradao = null;
	private CompraController compracontroller;
	
	public DetalleCompraController() {
		detallecompradao = new DetalleCompraDaoImpl();
		compracontroller = new CompraController();
	}
	
	public List<DetalleCompra> listarDetalleCompra(){
		List<DetalleCompra> listaDetalleCompra = null;
		listaDetalleCompra = detallecompradao.listarDetalleCompra();
		return listaDetalleCompra;
	}
	
	public List<DetalleCompra> listarDetalleCompraPorNumeroCompra(String numeroCompra){
	    List<DetalleCompra> listaDetalleCompra = new ArrayList<>();

	    int idCompra = compracontroller.obtenerIdCompraPorNumeroCompra(numeroCompra);

	    if (idCompra > 0) {
	        listaDetalleCompra = detallecompradao.listarDetalleCompraPorIdCompra(idCompra);
	    } else {
	        // Manejar el caso en que no se encontró la compra
	        System.err.println("ERROR: No se encontró la compra correspondiente al número " + numeroCompra);
	        // Puedes lanzar una excepción aquí si prefieres
	    }

	    return listaDetalleCompra;

	}
	
	public void registrarDetalleCompra(DetalleCompra detallecompra) {
		
		detallecompradao.agregarDetalleCompra(detallecompra);
	}
}
