package Controller;

import java.util.List;

import Dao.CompraDao;
import DaoImpl.CompraDaoImpl;
import Model.Compra;

public class CompraController {
	
	private CompraDao compradao = null;
	
	public CompraController() {
		compradao = new CompraDaoImpl();
	}
	
	public List<Compra> listarCompra(){
		List<Compra> listaCompra = null;
		listaCompra = compradao.listarCompras();
		return listaCompra;
	}
	
	public String generarNumeroOrdenCompra() {
		String ultimoNumeroCompra = obtenerUltimoNumeroCompra();
		
		if(ultimoNumeroCompra != null) {
			char letraActual = ultimoNumeroCompra.charAt(0);
			int numeroActual = Integer.parseInt(ultimoNumeroCompra.substring(1));
			
			if(numeroActual < 999999) {
				numeroActual++;
			}
			else {
				numeroActual = 1;
				letraActual = (char) (letraActual + 1); // aumenta la letra en uno: A, B, C, D, E
			}
			
			String numeroCompra = letraActual + String.format("%06d", numeroActual);
			
			return numeroCompra;
		}
		else {
			return null;
		}
	}
	
	private String obtenerUltimoNumeroCompra() {
		return compradao.obtenerUltimoNumeroCompra();
	}
	
	private void actualizarNumeroCompra(String nuevoNumeroCompra) {
		compradao.actualizarNumeroCompra(nuevoNumeroCompra);
	}
	
	public int registrarVenta(String numeroCompra, int idProveedor, double total, int idModoPago, int idEmpleado) {
		Compra compra = new Compra();
		compra.setNumero_compra(numeroCompra);
		compra.setId_proveedor(idProveedor);
		compra.setTotal(total);
		compra.setId_modo_pago(idModoPago);
		compra.setId_empleado(idEmpleado);
		
		int idCompra = compradao.agregarOrdenCompra(compra);
		return idCompra;
	}
	
	public int obtenerIdCompraPorNumeroCompra(String numeroCompra) {
		return compradao.obtenerIdCompraPorNumeroCompra(numeroCompra);
	}
}